/**
 * 
 */
package com.waynesun.common.biz.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.UrlUtils;


public class MyRedirectStrategy implements RedirectStrategy {

	private boolean contextRelative;

	private String redirectUrl;

	@Override
	public void sendRedirect(HttpServletRequest request, HttpServletResponse response,
			String url) throws IOException {

		String localRedirectUrl = calculateRedirectUrl(request.getContextPath(), url);
		localRedirectUrl = response.encodeRedirectURL(localRedirectUrl);

		response.sendRedirect(this.getRedirectUrl());
	}

	private String calculateRedirectUrl(String contextPath, String url) {
        if (!UrlUtils.isAbsoluteUrl(url)) {
            if (contextRelative) {
                return url;
            } else {
                return contextPath + url;
            }
        }

        // Full URL, including http(s)://

        if (!contextRelative) {
            return url;
        }

        // Calculate the relative URL from the fully qualified URL, minus the scheme and base context.
        url = url.substring(url.indexOf("://") + 3); // strip off scheme
        url = url.substring(url.indexOf(contextPath) + contextPath.length());

        if (url.length() > 1 && url.charAt(0) == '/') {
            url = url.substring(1);
        }

        return url;
    }

    /**
     * If <tt>true</tt>, causes any redirection URLs to be calculated minus the protocol
     * and context path (defaults to <tt>false</tt>).
     */
    public void setContextRelative(boolean useRelativeContext) {
        this.contextRelative = useRelativeContext;
    }

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
