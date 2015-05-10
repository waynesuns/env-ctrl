package com.waynesun.common.biz.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.AuthorizationRequest;

import com.waynesun.pojo.BasePojo;


public class FtpUser extends BasePojo implements org.apache.ftpserver.ftplet.User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5013465380970450792L;
	private String userId;
	private String homedirectory;
	private int enableflag=1;
	private int writepermission=0;
	private int idletime=0;
	private int uploadrate=0;
	private int downloadrate=0;
	private int maxloginnumber=0;
	private int maxloginperip=0;
	private String name;
	private String password;
	
	public String getHomedirectory() {
		return homedirectory;
	}
	public void setHomedirectory(String homedirectory) {
		this.homedirectory = homedirectory;
	}
	public int getEnableflag() {
		return enableflag;
	}
	public void setEnableflag(int enableflag) {
		this.enableflag = enableflag;
	}
	public int getWritepermission() {
		return writepermission;
	}
	public void setWritepermission(int writepermission) {
		this.writepermission = writepermission;
	}
	public int getIdletime() {
		return idletime;
	}
	public void setIdletime(int idletime) {
		this.idletime = idletime;
	}
	public int getUploadrate() {
		return uploadrate;
	}
	public void setUploadrate(int uploadrate) {
		this.uploadrate = uploadrate;
	}
	public int getDownloadrate() {
		return downloadrate;
	}
	public void setDownloadrate(int downloadrate) {
		this.downloadrate = downloadrate;
	}
	public int getMaxloginnumber() {
		return maxloginnumber;
	}
	public void setMaxloginnumber(int maxloginnumber) {
		this.maxloginnumber = maxloginnumber;
	}
	public int getMaxloginperip() {
		return maxloginperip;
	}
	public void setMaxloginperip(int maxloginperip) {
		this.maxloginperip = maxloginperip;
	}
	private List<Authority> authorities = new ArrayList<Authority>();
	public void setAuthorities(List<Authority> authorities) {
        if (authorities != null) {
            this.authorities = Collections.unmodifiableList(authorities);
        } else {
            this.authorities = null;
        }
    }
	@Override
	public AuthorizationRequest authorize(AuthorizationRequest request) {
		// TODO Auto-generated method stub
		if(authorities == null) {
            return null;
        }
        
        boolean someoneCouldAuthorize = false;
        for (Authority authority : authorities) {
            if (authority.canAuthorize(request)) {
                someoneCouldAuthorize = true;

                request = authority.authorize(request);

                // authorization failed, return null
                if (request == null) {
                    return null;
                }
            }

        }

        if (someoneCouldAuthorize) {
            return request;
        } else {
            return null;
        }
	}

	@Override
	public List<Authority> getAuthorities() {
		 if (authorities != null) {
	            return Collections.unmodifiableList(authorities);
	        } else {
	            return null;
	        }
	}

	@Override
	public List<Authority> getAuthorities(Class<? extends Authority> clazz) {
		List<Authority> selected = new ArrayList<Authority>();

        for (Authority authority : authorities) {
            if (authority.getClass().equals(clazz)) {
                selected.add(authority);
            }
        }

        return selected;
	}

	@Override
	public boolean getEnabled() {
		// TODO Auto-generated method stub
		return this.enableflag>0;
	}

	@Override
	public String getHomeDirectory() {
		// TODO Auto-generated method stub
		return this.homedirectory;
	}

	@Override
	public int getMaxIdleTime() {
		// TODO Auto-generated method stub
		return idletime;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}