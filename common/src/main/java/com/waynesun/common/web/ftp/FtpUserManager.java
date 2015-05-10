package com.waynesun.common.web.ftp;


import java.util.ArrayList;
import java.util.List;

import org.apache.ftpserver.ftplet.Authentication;
import org.apache.ftpserver.ftplet.AuthenticationFailedException;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.usermanager.AnonymousAuthentication;
import org.apache.ftpserver.usermanager.Md5PasswordEncryptor;
import org.apache.ftpserver.usermanager.PasswordEncryptor;
import org.apache.ftpserver.usermanager.UsernamePasswordAuthentication;
import org.apache.ftpserver.usermanager.impl.ConcurrentLoginPermission;
import org.apache.ftpserver.usermanager.impl.TransferRatePermission;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.query.SimpleQuery;
import com.waynesun.dao.query.condition.QueryConditionAssenble;
import com.waynesun.common.biz.user.FtpUser;
import com.waynesun.common.biz.user.FtpUserQC;


public class FtpUserManager  implements UserManager{
	 private PasswordEncryptor passwordEncryptor = new Md5PasswordEncryptor();
	public PasswordEncryptor getPasswordEncryptor() {
		return passwordEncryptor;
	}

	public void setPasswordEncryptor(PasswordEncryptor passwordEncryptor) {
		this.passwordEncryptor = passwordEncryptor;
	}

	@Override
	public User getUserByName(String username) throws FtpException {
		// TODO Auto-generated method stub
		FtpUserQC qc=new FtpUserQC();
		qc.setName(username);
		SimpleQuery sq = new SimpleQuery();
		QueryConditionAssenble qca = new QueryConditionAssenble();
		qca.setCondition(qc);
		sq.setQueryCondtion(qca);
		FtpUser user = DaoFactory.getInstance().getQueryDao().uniqueResult(FtpUser.class, sq, true);
		if(user!=null){
		List<Authority> selected = new ArrayList<Authority>();
		if(user.getWritepermission()>0){
			selected.add(new WritePermission());
		}
			selected.add(new ConcurrentLoginPermission(user.getMaxloginnumber(),user.getMaxloginperip()));
			selected.add(new TransferRatePermission(user.getDownloadrate(),user.getUploadrate()));
			user.setAuthorities(selected);
		}
		return user;
	}

	@Override
	public String[] getAllUserNames() throws FtpException {
		// TODO Auto-generated method stub
		List<FtpUser> userList = DaoFactory.getInstance().getQueryDao().list(FtpUser.class, null, new SimpleQuery(), true).getResults();
		String[] usernames=new String[userList.size()];
		int i=0;
		for (FtpUser abstractUsers : userList) {
			usernames[i]=abstractUsers.getName();
			i++;
		}
		return usernames;
	}

	@Override
	public void delete(String username) throws FtpException {
		// TODO Auto-generated method stub
	}

	@Override
	public void save(User user) throws FtpException {
		// TODO Auto-generated method stub

        // null value check
	}

	@Override
	public boolean doesExist(String username) throws FtpException {
		// TODO Auto-generated method stub
		FtpUser user=(FtpUser)getUserByName(username);
		if(user==null)
		return false;
		return true;
	}

	@Override
	public User authenticate(Authentication authentication)
			throws AuthenticationFailedException {
        if (authentication instanceof UsernamePasswordAuthentication) {
            UsernamePasswordAuthentication upauth = (UsernamePasswordAuthentication) authentication;

            String username = upauth.getUsername();
            String password = upauth.getPassword();

            if (username == null) {
                throw new AuthenticationFailedException("Authentication failed");
            }

            if (password == null) {
                password = "";
            }
            try {
            	User user=(User)getUserByName(username);
            if (password.equals(user.getPassword())) {
                return user;
            } else {
                throw new AuthenticationFailedException(
                        "Authentication failed");
            }
            } catch (FtpException e) {
                throw new AuthenticationFailedException(
                        "Authentication failed", e);
            }
        } else if (authentication instanceof AnonymousAuthentication) {
            try {
                if (doesExist("anonymous")) {
                    return getUserByName("anonymous");
                } else {
                    throw new AuthenticationFailedException(
                            "Authentication failed");
                }
            } catch (AuthenticationFailedException e) {
                throw e;
            } catch (FtpException e) {
                throw new AuthenticationFailedException(
                        "Authentication failed", e);
            }
        } else {
            throw new IllegalArgumentException(
                    "Authentication not supported by this user manager");
        }
	}

	@Override
	public String getAdminName() throws FtpException {
		// TODO Auto-generated method stub
		return "admin";
	}

	@Override
	public boolean isAdmin(String username) throws FtpException {
		// TODO Auto-generated method stub
		return "admin".equals(username);
	}
	
}

