package com.waynesun.common.util.init;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.utils.file.AbstractFile;
import com.waynesun.utils.file.binary.Zip;
import com.waynesun.utils.file.document.Doc;
import com.waynesun.utils.file.document.Pdf;
import com.waynesun.utils.file.document.Ppt;
import com.waynesun.utils.file.document.Xls;
import com.waynesun.utils.file.media.Audio;
import com.waynesun.utils.file.media.Image;
import com.waynesun.utils.file.media.Vido;
import com.waynesun.common.biz.cache.AuthConst;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.role.Role;

/**
 * 应用初始化
 * 
 * @author wayne
 * 
 */
public class AppInit implements InitializingBean
{
	/** 权限service */
	private com.waynesun.common.biz.security.SecurityManager securityManager;
	private Cache cache = CacheFactory.getInstance().getCache();

	@Override
//	@Transactional
	public void afterPropertiesSet() throws Exception
	{
		
		this.initUrlAuthorities();
		this.initSysResource();
		this.initSysRole();
		this.initFileMaping();
	}

	/**
	 * 初始化待验证URL
	 */
	public void initUrlAuthorities()
	{
		Map<String, String> urlAuthorities = securityManager.loadUrlAuthorities();
		cache.put(AuthConst.LOAD_URL_AUTHORITY, urlAuthorities);
	}
	
	/**
	 * 初始化系统级菜单
	 */
	public void initSysResource()
	{
		List<Resource> list = securityManager.loadSysResource();
		cache.put(AuthConst.LOAD_SYS_RESOURCE, list);
	}
	
	public void initSysRole()
	{
		List<Role> list = securityManager.loadSysRole();
		cache.put(AuthConst.LOAD_SYS_ROLE, list);
	}
	
	public void initFileMaping(){
		AbstractFile.addMapping("zip", Zip.class);
		AbstractFile.addMapping("rar", Zip.class);
		AbstractFile.addMapping("doc", Doc.class);
		AbstractFile.addMapping("docx", Doc.class);
		AbstractFile.addMapping("pdf", Pdf.class);
		AbstractFile.addMapping("ppt", Ppt.class);
		AbstractFile.addMapping("xls", Xls.class);
		AbstractFile.addMapping("xlsx", Xls.class);
		AbstractFile.addMapping("mp3", Audio.class);
		AbstractFile.addMapping("wmv", Audio.class);
		AbstractFile.addMapping("jpg", Image.class);
		AbstractFile.addMapping("gif", Image.class);
		AbstractFile.addMapping("bmp", Image.class);
		AbstractFile.addMapping("mp4", Vido.class);
		AbstractFile.addMapping("rmvb", Vido.class);
		AbstractFile.addMapping("avi", Vido.class);
		AbstractFile.addMapping("mkv", Vido.class);
	}
	
	public com.waynesun.common.biz.security.SecurityManager getSecurityManager()
	{
		return securityManager;
	}

	public void setSecurityManager(com.waynesun.common.biz.security.SecurityManager securityManager)
	{
		this.securityManager = securityManager;
	}
}
