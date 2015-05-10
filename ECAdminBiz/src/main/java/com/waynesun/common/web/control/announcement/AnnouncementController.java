package com.waynesun.common.web.control.announcement;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.dao.query.pages.ResultPages;
import com.waynesun.dao.query.result.QueryResult;
import com.waynesun.exception.BizException;
import com.waynesun.pojo.Pages;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.JsonStringUtils;
import com.waynesun.utils.UserUtils;
import com.waynesun.utils.WebUtils;
import com.waynesun.utils.export.param.ExportParam;
import com.waynesun.utils.export.param.it.DateFormatEPIT;
import com.waynesun.utils.export.param.vt.BeanPropertyEPVT;
import com.waynesun.utils.export.param.vt.StringEPVT;
import com.waynesun.common.biz.announcement.AbstractAnnouncementAuthConf;
import com.waynesun.common.biz.announcement.Announcement;
import com.waynesun.common.biz.announcement.AnnouncementQC;
import com.waynesun.common.biz.announcement.AnnouncementUtils;
import com.waynesun.common.biz.announcement.DealerAnnouncementAuthConf;
import com.waynesun.common.biz.area.ProvinceArea;
import com.waynesun.common.biz.attachment.Attachment;
import com.waynesun.common.biz.attachment.AttachmentQC;
import com.waynesun.common.biz.attachment.AttachmentUtils;
import com.waynesun.common.biz.dealerarea.AbstractDealerArea;
import com.waynesun.common.biz.dealerarea.DealerAreaCacheUtils;
import com.waynesun.common.biz.dealerarea.rel.DealerAreaRel;
import com.waynesun.common.biz.dictionary.DictionaryCacheUtils;
import com.waynesun.common.biz.dictionary.DictionaryItem;
import com.waynesun.common.biz.user.AbstractDealer;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.DealerUtils;
import com.waynesun.common.biz.veh.VehicleBrand;
import com.waynesun.common.biz.veh.VehicleBrandCacheUtils;
import com.waynesun.common.biz.veh.VehicleBrandUtils;
import com.waynesun.common.util.datatable.DataTablePages;
import com.waynesun.common.web.control.AbstractBindController;

@Controller
@RequestMapping(value = "/announcement")
public class AnnouncementController extends AbstractBindController
{

	public static final long FILE_SIZE = 5 * 1024 * 1024;

	@RequestMapping(value = "/show/home", method = RequestMethod.GET)
	public String showPageView(HttpServletRequest request) throws Exception
	{
		List<VehicleBrand> brandList = VehicleBrandUtils.findAllVehicleBrands();
		request.setAttribute("brandJson", JsonStringUtils.generateJSONString(brandList, getHeader()));
		return ".main~/bbs/home.jsp";
	}
	
	/**
	 * 获取大区
	 */
	@RequestMapping(value = "/dealerArea_list", method = RequestMethod.POST)
	@ResponseBody
	public String getDealerAreaByBrandId(String brandId) throws Exception
	{
		List<AbstractDealerArea> list = DealerAreaCacheUtils.getDealerAraea(brandId);
		return JsonStringUtils.generateJSONString(list, getHeader());
	}
	
	/**
	 * 获取公告编号 
	 */
	@RequestMapping(value = "/serialNumber", method = RequestMethod.POST)
	@ResponseBody
	public String getSerialNumberStr() throws Exception
	{
		return AnnouncementUtils.getSerialNumber(); 
	}
	
	/**
	 * 获取网点编号
	 */
	@RequestMapping(value = "/dealer_list", method = RequestMethod.POST)
	@ResponseBody
	public String getDealer(String brandId,String dealerAreaId,String province) throws Exception
	{
		List<AbstractDealer> list = DealerUtils.getDealers(brandId, dealerAreaId, province);
		List<ExportParam> headers = getHeader();
		headers.add(new ExportParam(new StringEPVT("code"), new BeanPropertyEPVT("dealerCode"), ""));
		//headers.add(new ExportParam(new StringEPVT("parentId"), new BeanPropertyEPVT("parent"), ""));
		return JsonStringUtils.generateJSONString(list, headers);
	}
	/**
	 * 获取省份
	 */
	@RequestMapping(value = "/province_list", method = RequestMethod.POST)
	@ResponseBody
	public String getProvinceByDealerAreaId(String dealerAreaId,String brandId) throws Exception
	{
		List<ProvinceArea> provincelist = new ArrayList<ProvinceArea>();
		List<AbstractDealerArea> list = DealerAreaCacheUtils.getDealerAraea(brandId);
		for (AbstractDealerArea abstractDealerAraea : list) { 
			if(abstractDealerAraea.getId().equals(dealerAreaId)){
				Set<DealerAreaRel> seet = abstractDealerAraea.getDealerAreaRels();
				for (DealerAreaRel dealerAreaRel : seet) {
					provincelist.add(dealerAreaRel.getArea());
				}
			}
		}
		return JsonStringUtils.generateJSONString(provincelist, getHeaderProvince());
	}
	/**
	 * 获取未发布公告列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/under_released_list", method = RequestMethod.POST)
	@ResponseBody
	public String getAnnouncementListIsUnderReleased(HttpServletResponse response) throws Exception
	{
		AnnouncementQC qc = new AnnouncementQC();
		qc.setReleased(false);
		qc.setState(PojoState.NORMAL);
		List<Announcement> list = AnnouncementUtils.findAnnouncementIsReleased(qc);
		return praseJsonByUnReleased(list);
	}

	/**
	 * 获取已发布公告列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/released_list", method = RequestMethod.POST)
	@ResponseBody
	public String getAnnouncementListIsReleased(HttpServletResponse response) throws Exception
	{
		AnnouncementQC qc = new AnnouncementQC();
		qc.setReleased(true);
		qc.setState(PojoState.NORMAL);
		List<Announcement> list = AnnouncementUtils.findAnnouncementIsReleased(qc);
		return praseJsonByReleased(list);
	}

	/**
	 * 附件上传
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/upload", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doUpload(@RequestParam() MultipartFile[] files) throws Exception
	{
		Map<String, String> attachFileInfo = new HashMap<String, String>();
		for (MultipartFile file : files)
		{
			if (FILE_SIZE < file.getSize())
				throw new BizException("error.file.max.size");
			String fileName = file.getOriginalFilename();
			InputStream in = file.getInputStream();

			Attachment attachment = new Attachment();
			attachment.setFileName(fileName);
			String filePath = saveFile(in, fileName);
			attachment.setFilePath(filePath);
			attachment.update();

			attachFileInfo.put("id", attachment.getId());
			attachFileInfo.put("fileName", com.waynesun.utils.StringUtils.escapeHtmlJson(attachment.getFileName()));
		}
		return ajaxJson(attachFileInfo);
	}

	/**
	 * 附件下载
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/download")
	public void getFile(String id, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		Attachment attachment = AttachmentUtils.getAttachmentByAnnouncementId(id);
		if (attachment == null)
			throw new BizException("error.file.not.exists");
		String filePath = attachment.getFilePath();
		outputFile(filePath, request, response);
	}

	static void outputFile(String filePath, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		File directory = new File(filePath);
		File[] files = directory.listFiles();
		File file = null;
		if (files == null || files.length <= 0)
			throw new BizException("file.empty");
		file = files[0];
		// set response header
		response.addHeader("pragma", "no-cache");
		response.addHeader("cache-control", "no-cache");
		response.addDateHeader("expries", 0);
		response.setContentLength((int) file.length());
		// convert utf-8 to iso
		String fileName = "";
		FileInputStream in = null;
		ServletOutputStream out = null;
		try
		{
			fileName = new String(file.getName().getBytes("utf-8"), "ISO8859-1");
			if (WebUtils.isIE(request))
				fileName = com.waynesun.utils.StringUtils.encode(file.getName(), "UTF-8");
			// set file name
			response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
			// read file and output
			in = new FileInputStream(file);
			out = response.getOutputStream();
			byte[] b = new byte[1024];
			while (in.read(b) > 0)
			{
				out.write(b);
			}

			out.flush();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}
	}

	/**
	 * 保存文件到目录，文件保存的路径是：<br>
	 * [系统配置的保存位置]/[域名]/[用户id]/[文件的path属性（32位uuid）]/实际文件名<br>
	 * 事实上是一个文件拥有一个目录，以保证原始文件名被保存，读取时无须再读数据库
	 * 
	 * @param ins
	 *            输入流
	 * @throws Exception
	 */
	public String saveFile(InputStream ins, String fileName) throws Exception
	{
		// 产生目录id
		String path = UUID.randomUUID().toString();
		path = "C:/upload" + "/" + path;
		// 创建目录
		File file = new File(path);
		file.mkdirs();
		// 写入文件
		file = new File(path + "/" + fileName);
		FileOutputStream fos = new FileOutputStream(file);
		BufferedInputStream inBuff = new BufferedInputStream(ins);
		BufferedOutputStream outBuff = new BufferedOutputStream(fos);
		byte[] b = new byte[1024];
		int len;
		while ((len = inBuff.read(b)) != -1)
		{
			outBuff.write(b, 0, len);
		}
		// 刷新此缓冲的输出流
		outBuff.flush();
		// 关闭流
		inBuff.close();
		outBuff.close();
		fos.close();
		return path;
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doAdd(HttpServletRequest request, HttpServletResponse response, Announcement announcement) throws Exception
	{
		String[] dealerCodes = request.getParameterValues("dealerCode");
		String[] dealerCodeHiddens = request.getParameterValues("dealerCodeHidden");
		String brandId = request.getParameter("brand");
		String dealerAreaId = request.getParameter("dealerArea");
		announcement.setBrandId(VehicleBrandCacheUtils.getBrandById(brandId));
		announcement.setDealerAreaId(DealerAreaCacheUtils.getDealerAraeaById(dealerAreaId));
		announcement.setCategory((DictionaryItem) DictionaryCacheUtils.getDictionaryItem("10027", request.getParameter("categoryId")));
		announcement.setDepartment((DictionaryItem) DictionaryCacheUtils.getDictionaryItem("10028", request.getParameter("departmentId")));
		announcement.setReleased(false);
		announcement.setState(PojoState.valueOf(0));
		announcement.setSerialNumber(AnnouncementUtils.getSerialNumber());
		announcement.update();
		announcement.addAuthConfs(dealerCodes,dealerCodeHiddens);
		String[] fileIds = request.getParameterValues("fileId");
		if (fileIds != null)
		{
			AttachmentQC qc=new AttachmentQC();
			qc.setIds(Arrays.asList(fileIds));
			SimpleQuery sq=new SimpleQuery();
			QueryConditionAssenble qca = new QueryConditionAssenble();
			qca.setCondition(qc);
			sq.setQueryCondtion(qca);
			List<Attachment> attachments = DaoFactory.getInstance().getQueryDao().list(Attachment.class, null, sq, true).getResults();
			for (Attachment attachment : attachments)
				attachment.relation(announcement);
		}
		List<Announcement> list = new ArrayList<Announcement>();
		list.add(announcement);
		return praseJsonByUnReleased(list);
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doModify(HttpServletRequest request, HttpServletResponse response, String fileId) throws Exception
	{
		Announcement announcement = getAnnouncement(request.getParameter("id"));
		String[] dealerCodeHiddens = request.getParameterValues("dealerCodeHidden");
		deleteFile(announcement,fileId);
		if (announcement.isReleased())
			throw new BizException("bbs.isreleased");
		if (announcement.getState().getState() == 1)
			throw new BizException("bbs.isDelete");
		String[] dealerCodes = request.getParameterValues("dealerCode");
		String brandId = request.getParameter("brand");
		String dealerAreaId = request.getParameter("dealerArea");
		announcement.setProvince(request.getParameter("province"));
		announcement.setContactPerson(request.getParameter("contactPerson"));
		announcement.setContactPhone(request.getParameter("contactPhone"));
		announcement.setProvince(request.getParameter("province"));
		announcement.setBrandId(VehicleBrandCacheUtils.getBrandById(brandId));
		announcement.setDealerAreaId(DealerAreaCacheUtils.getDealerAraeaById(dealerAreaId));
		announcement.setCategory((DictionaryItem) DictionaryCacheUtils.getDictionaryItem("10027", request.getParameter("categoryId")));
		announcement.setDepartment((DictionaryItem) DictionaryCacheUtils.getDictionaryItem("10028", request.getParameter("departmentId")));
		announcement.addAuthConfs(dealerCodes,dealerCodeHiddens);
		announcement.setTitle(request.getParameter("title"));
		announcement.setContent(request.getParameter("content"));
		announcement.update();
		if (StringUtils.isEmpty(fileId))
		{
			announcement.setAttachment(null);
			announcement.update();
		}
		else
		{
			Attachment attachment = DaoFactory.getInstance().getQueryDao().get(Attachment.class, fileId,true);
			announcement.setAttachment(attachment);
			announcement.update();
			attachment.setAnnouncement(announcement);
			attachment.update();
		}

		List<Announcement> list = new ArrayList<Announcement>();
		list.add(announcement);
		return praseJsonByUnReleased(list);
	}

//	@Transactional
	private void deleteFile(Announcement announcement,String fileId)
	{
		if (announcement.getAttachment() == null)
			return;
		Attachment attachment = DaoFactory.getInstance().getQueryDao().get(Attachment.class, fileId,true);
		if (attachment == null)
			return;
		if(attachment.getId().equalsIgnoreCase(fileId))
			return;
		attachment.delete();
	}

	/**
	 * 发布
	 * 
	 * @return
	 */
	@RequestMapping(value = "/release", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doRelease(HttpServletRequest request)
	{
		String[] ids = request.getParameterValues("announcementId");
		List<String> idList = Arrays.asList(ids);
		AnnouncementQC qc=new AnnouncementQC();
		qc.setIds(idList);
		SimpleQuery sq=new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		List<Announcement> announcements = DaoFactory.getInstance().getQueryDao().list(Announcement.class, null, sq, true).getResults();
		for (Announcement a : announcements)
		{
			if (a.isReleased())
				throw new BizException("bbs.isreleased");
			if (a.getState().getState() == 1)
				throw new BizException("bbs.isDelete");
			a.setReleased(true);
			a.setReleaseDate(new Date());
			a.update();
		}
		return ajaxJson(idList);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@ResponseBody
//	@Transactional
	public String doDelete(HttpServletRequest request)
	{
		String[] ids = request.getParameterValues("announcementId");
		String state=request.getParameter("state");
		List<String> idList = Arrays.asList(ids);
		AnnouncementQC qc=new AnnouncementQC();
		qc.setIds(idList);
		qc.setReleased(Boolean.parseBoolean(state));
		SimpleQuery sq=new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		List<Announcement> announcements = DaoFactory.getInstance().getQueryDao().list(Announcement.class, null, sq, true).getResults();
		for (Announcement a : announcements)
		{
			if (a.getState().getState() == 1)
				throw new BizException("bbs.isDelete");
			Set<AbstractAnnouncementAuthConf> confs = a.getAuthConfs();
			if(confs!=null&&confs.size()>0){
				for (AbstractAnnouncementAuthConf conf : confs){
					if(conf instanceof DealerAnnouncementAuthConf){
						conf.delete();
					}
				}
			}
			a.delete();
			a.setState(PojoState.DELETED);
		}
		return ajaxJson(idList);
	}

	/**
	 * 取得公告
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/get_announcement", method = RequestMethod.POST)
	@ResponseBody
	public String getAnnouncementById(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Announcement announcement = getAnnouncement(request.getParameter("id"));
		if (announcement.isReleased())
			throw new BizException("bbs.isreleased");
		if (announcement.getState().getState() == 1)
			throw new BizException("bbs.isDelete");
		List<Announcement> list = new ArrayList<Announcement>();
		list.add(announcement);
		return praseJsonByUnReleased(list);
	}

	private Announcement getAnnouncement(String id)
	{
		if (StringUtils.isEmpty(id))
			throw new BizException("id is null");
		Announcement announcement = (Announcement) DaoFactory.getInstance().getQueryDao().get(Announcement.class, id, true);
		return announcement;
	}
	
	private DealerAnnouncementAuthConf getDealerAnnouncementAuthConf(String id)
	{
		if (StringUtils.isEmpty(id))
			throw new BizException("id is null");
		DealerAnnouncementAuthConf conf = (DealerAnnouncementAuthConf) DaoFactory.getInstance().getQueryDao().get(DealerAnnouncementAuthConf.class, id, true);
		return conf;
	}

	private String praseJsonByUnReleased(List<Announcement> list) throws Exception
	{
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("title"), new BeanPropertyEPVT("title"), ""));
		exportParams.add(new ExportParam(new StringEPVT("createTime"), new BeanPropertyEPVT("createTime"),new DateFormatEPIT("yyyy-MM-dd"), null));
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("content"), new BeanPropertyEPVT("content"), ""));
		exportParams.add(new ExportParam(new StringEPVT("existsFile"), new BeanPropertyEPVT("existsFile"), ""));
		exportParams.add(new ExportParam(new StringEPVT("fileName"), new BeanPropertyEPVT("attachment.fileName"), ""));
		exportParams.add(new ExportParam(new StringEPVT("fileId"), new BeanPropertyEPVT("attachment.id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("serialNumber"), new BeanPropertyEPVT("serialNumber"), ""));
		exportParams.add(new ExportParam(new StringEPVT("category"), new BeanPropertyEPVT("category.value"), ""));
		exportParams.add(new ExportParam(new StringEPVT("department"), new BeanPropertyEPVT("department.value"), ""));
		exportParams.add(new ExportParam(new StringEPVT("brandId"), new BeanPropertyEPVT("brandId.id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("dealerAreaId"), new BeanPropertyEPVT("dealerAreaId.id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("province"), new BeanPropertyEPVT("province"), ""));
		exportParams.add(new ExportParam(new StringEPVT("contactPerson"), new BeanPropertyEPVT("contactPerson"), ""));
		exportParams.add(new ExportParam(new StringEPVT("contactPhone"), new BeanPropertyEPVT("contactPhone"), ""));
		exportParams.add(new ExportParam(new StringEPVT("dealerId"), new BeanPropertyEPVT("dealerId"), ""));
		return JsonStringUtils.generateDataTableJSONString(list, exportParams);
	}

	private String praseJsonByReleased(List<Announcement> list) throws Exception
	{
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("title"), new BeanPropertyEPVT("title"), ""));
		exportParams.add(new ExportParam(new StringEPVT("releaseDate"), new BeanPropertyEPVT("releaseDate"),new DateFormatEPIT("yyyy-MM-dd"), ""));
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("content"), new BeanPropertyEPVT("content"), ""));
		exportParams.add(new ExportParam(new StringEPVT("createTime"), new BeanPropertyEPVT("createTime"),new DateFormatEPIT("yyyy-MM-dd"), ""));
		exportParams.add(new ExportParam(new StringEPVT("existsFile"), new BeanPropertyEPVT("existsFile"), ""));
		exportParams.add(new ExportParam(new StringEPVT("fileName"), new BeanPropertyEPVT("attachment.fileName"), ""));
		exportParams.add(new ExportParam(new StringEPVT("fileId"), new BeanPropertyEPVT("attachment.id"), ""));
		return JsonStringUtils.generateDataTableJSONString(list, exportParams);
	}
	
	private List<ExportParam> getHeader(){
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"), ""));
		return exportParams;
	}
	private List<ExportParam> getHeaderProvince(){
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("id"), new BeanPropertyEPVT("id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("code"), new BeanPropertyEPVT("code"), ""));
		exportParams.add(new ExportParam(new StringEPVT("name"), new BeanPropertyEPVT("name"), ""));
		return exportParams;
	}
	

	/**
	 * 最新公告列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/file_list/new", method = RequestMethod.POST)
	@ResponseBody
	public String getAnnouncement(HttpServletRequest request, HttpServletResponse response, DataTablePages pages, DateTableAjaxParam param) throws Exception
	{
//		AnnouncementQC qc = new AnnouncementQC();
//		qc.setState(PojoState.NORMAL);
//		qc.setReleased(true);
		AbstractUser user = (AbstractUser)UserUtils.getUser();
//		qc.setAuthConfs_dealer_id(user.getDealer().getId()); 
		//List<Announcement> list = AnnouncementUtils.getAnnouncementByQC(qc, pages);
		QueryResult<DealerAnnouncementAuthConf> qr = user.getAllowVisitAnnouncement(pages);
		ResultPages rp = qr.getPages();
		List<DealerAnnouncementAuthConf> list = qr.getResults();
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		if (param.isHaveParam())
		{
			AnnouncementQC tempQC = new AnnouncementQC();
			tempQC.setState(PojoState.NORMAL);
			tempQC.setReleased(true);
			SimpleQuery sq = new SimpleQuery();
			QueryConditionAssenble qca = new QueryConditionAssenble();
			qca.setCondition(tempQC);
			sq.setQueryCondtion(qca);
			Pages tempPages = new Pages();
			tempPages.setPageSize(1);
			DaoFactory.getInstance().getQueryDao().list(Announcement.class, tempPages, sq, true);
			
			sb.append("\"iTotalRecords\":" +tempPages.getTotalRow());
		}
		else
			sb.append("\"iTotalRecords\":" + rp.getTotalRow());
		sb.append(",");
		sb.append("\"iTotalDisplayRecords\":" + rp.getTotalRow());
		sb.append(",");
		sb.append("\"sEcho\":" + pages.getsEcho());
		sb.append(",");
		sb.append("\"aaData\":");
		sb.append(JsonStringUtils.generateJSONString(list, getFileTable()));
		sb.append("}");
		return sb.toString();
	}

	private List<ExportParam> getFileTable()
	{
		List<ExportParam> exportParams = new ArrayList<ExportParam>();
		exportParams.add(new ExportParam(new StringEPVT("title"), new BeanPropertyEPVT("announcement.title"), ""));
		exportParams.add(new ExportParam(new StringEPVT("fileName"), new BeanPropertyEPVT("announcement.attachment.fileName"), ""));
		exportParams.add(new ExportParam(new StringEPVT("announcementId"), new BeanPropertyEPVT("announcement.id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("attachmentId"), new BeanPropertyEPVT("announcement.attachment.id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("anconfId"), new BeanPropertyEPVT("id"), ""));
		exportParams.add(new ExportParam(new StringEPVT("status"), new BeanPropertyEPVT("status"), ""));
		return exportParams;
	}

	/**
	 * 重置公告
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show/get_content/new", method = RequestMethod.GET)
//	@Transactional
	public String doResetContent(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Announcement announcement = getAnnouncement(request.getParameter("announcementId"));
		// 修改为已读
		DealerAnnouncementAuthConf conf = getDealerAnnouncementAuthConf(request.getParameter("anconfId"));
		conf.setStatus(DealerAnnouncementAuthConf.READ);
		conf.update();
		if (announcement.getState().getState() == 1)
			throw new BizException("bbs.isDelete");
		request.setAttribute("announcement", announcement);
		return ".main~/bbs/content.jsp";
	}
	
	@RequestMapping(value = "/show/get_content_html/new", method = RequestMethod.POST)
	@ResponseBody
	public String getContentById(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Announcement announcement = getAnnouncement(request.getParameter("id"));
		List<Announcement> list = new ArrayList<Announcement>();
		list.add(announcement);
		return praseJsonByUnReleased(list);
	}
}
