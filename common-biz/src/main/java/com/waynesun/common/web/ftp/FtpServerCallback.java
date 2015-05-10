package com.waynesun.common.web.ftp;

import java.io.IOException;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.ftpserver.ftplet.DefaultFtplet;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.FtpletResult;
import org.apache.ftpserver.ftplet.User;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.file.AbstractFile;
import com.waynesun.common.biz.ftpfile.FileDaoSupport;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.UserQC;
import com.waynesun.common.utils.StorUtils;
import com.waynesun.common.web.ftp.command.StorArgument;

public class FtpServerCallback  extends DefaultFtplet{
	private FileDaoSupport ftpFileDao;
	
	public FileDaoSupport getFtpFileDao() {
		return ftpFileDao;
	}

	public void setFtpFileDao(FileDaoSupport ftpFileDao) {
		this.ftpFileDao = ftpFileDao;
	}

	@Override
	public FtpletResult afterCommand(FtpSession session, FtpRequest request,
			FtpReply reply) throws FtpException, IOException {
		// TODO Auto-generated method stub
		return super.afterCommand(session, request, reply);
	}

	@Override
	public FtpletResult onUploadEnd(FtpSession session, FtpRequest request)
			throws FtpException, IOException {
		// TODO Auto-generated method stub
		try {
		JSONObject obj = JSONObject.fromObject(request.getArgument());
        StorArgument argument= (StorArgument)JSONObject.toBean(obj,StorArgument.class);
        String fileName = StorUtils.getFilePathName(argument);
        AbstractFile	file = AbstractFile.generateInstance(argument.getFileName().substring(argument.getFileName().lastIndexOf("/")+1), fileName);
        file.setUuid(argument.getUuid());
        UserQC qc=new UserQC();
        User ftpuser=session.getUser();
        qc.setLogin_userName(ftpuser.getName());
        qc.setState(PojoState.NORMAL);
        SimpleQuery sq = new SimpleQuery();
        QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		AbstractUser user = DaoFactory.getInstance().getQueryDao().uniqueResult(AbstractUser.class, sq, true);
        file.setCreateUser(user);
        file.setCreateTime(new Date());
        ftpFileDao.saveFtpFile(file);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return FtpletResult.SKIP;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return FtpletResult.SKIP;
		}
       
		return super.onUploadEnd(session, request);
	}
	
}
