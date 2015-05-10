package com.waynesun.common.biz.security.interceptor;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.ConfigAttributeEditor;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.RegexUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

import com.waynesun.cache.Cache;
import com.waynesun.cache.CacheFactory;
import com.waynesun.common.biz.cache.AuthConst;

@SuppressWarnings("deprecation")
public class SecureResourceFilterInvocationDefinitionSource implements FilterInvocationSecurityMetadataSource, InitializingBean
{

	private UrlMatcher urlMatcher;
	private boolean useAntPath = true;
	private boolean lowercaseComparisons = true;

	@SuppressWarnings({ "unchecked" })
	@Override
	public Collection<ConfigAttribute> getAttributes(Object filter) throws IllegalArgumentException
	{
		FilterInvocation filterInvocation = (FilterInvocation) filter;
		String requestURI = filterInvocation.getRequestUrl();
		Map<String, String> urlAuthorities = this.getUrlAuthorities(filterInvocation);

		String grantedAuthorities = null;
		for (Iterator<Map.Entry<String, String>> iter = urlAuthorities.entrySet().iterator(); iter.hasNext();)
		{
			Map.Entry<String, String> entry = iter.next();
			String url = entry.getKey();
			if (urlMatcher.pathMatchesUrl(url, requestURI))
			{
				grantedAuthorities = entry.getValue();
				break;
			}
		}

		if (grantedAuthorities == null)
			grantedAuthorities = AuthConst.PUBLIC_AUTHORITY_ROLE_ID;
		if (grantedAuthorities != null)
		{
			ConfigAttributeEditor configAttrEditor = new ConfigAttributeEditor();
			configAttrEditor.setAsText(grantedAuthorities);
			return (Collection<ConfigAttribute>) configAttrEditor.getValue();
		}
//		ConfigAttributeEditor configAttrEditor = new ConfigAttributeEditor();
//		configAttrEditor.setAsText("-1");
//		return (Collection<ConfigAttribute>) configAttrEditor.getValue();
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes()
	{
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz)
	{
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		this.urlMatcher = new RegexUrlPathMatcher();
		if (useAntPath)
			this.urlMatcher = new AntUrlPathMatcher();
		if (lowercaseComparisons && !this.useAntPath)
			((RegexUrlPathMatcher) this.urlMatcher).setRequiresLowerCaseUrl(true);
		if (!lowercaseComparisons && this.useAntPath)
			((AntUrlPathMatcher) this.urlMatcher).setRequiresLowerCaseUrl(false);
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, String> getUrlAuthorities(FilterInvocation filterInvocation)
	{
		Cache cahe = CacheFactory.getInstance().getCache();
		return (Map<String, String>) cahe.get(AuthConst.LOAD_URL_AUTHORITY);
	}

	public UrlMatcher getUrlMatcher()
	{
		return urlMatcher;
	}

	public void setUrlMatcher(UrlMatcher urlMatcher)
	{
		this.urlMatcher = urlMatcher;
	}

	public boolean isUseAntPath()
	{
		return useAntPath;
	}

	public void setUseAntPath(boolean useAntPath)
	{
		this.useAntPath = useAntPath;
	}

	public boolean isLowercaseComparisons()
	{
		return lowercaseComparisons;
	}

	public void setLowercaseComparisons(boolean lowercaseComparisons)
	{
		this.lowercaseComparisons = lowercaseComparisons;
	}
}
