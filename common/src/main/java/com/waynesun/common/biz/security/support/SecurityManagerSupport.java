package com.waynesun.common.biz.security.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.waynesun.pojo.PojoState;
import com.waynesun.utils.StringUtils;
import com.waynesun.common.biz.cache.AuthConst;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.resource.ResourceQC;
import com.waynesun.common.biz.resource.ResourceUtils;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.role.RoleQC;
import com.waynesun.common.biz.role.RoleUtils;
import com.waynesun.common.biz.user.AbstractUser;
import com.waynesun.common.biz.user.LoginAccount;

public class SecurityManagerSupport implements UserDetailsService, com.waynesun.common.biz.security.SecurityManager {

//	@Autowired
//	public void init(SessionFactory sessionFactory)
//	{
//		super.setSessionFactory(sessionFactory);
//	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
		String[] userNameAndDealerCode = userName.split("\\|");

		String dealerCode = "";

		// 没有dealer code，说明是总部用户
		if (userNameAndDealerCode.length < 2) {
			dealerCode = "0";
		} else
			dealerCode = userNameAndDealerCode[1].trim();

		String dealerUserName = userNameAndDealerCode[0].trim();

		AbstractUser user = (AbstractUser) com.waynesun.common.biz.user.UserUtils.findUser(dealerCode, dealerUserName);

		if (user == null)
			throw new UsernameNotFoundException("登录名为：" + dealerUserName + "的用户不存在");

		LoginAccount account = user.getAccount();
		account.setUser(user);
		account.setMenuRandomKey(UUID.randomUUID());

		return account;
	}

	public Map<String, String> loadUrlAuthorities() {
		Map<String, String> urlAuthorities = new HashMap<String, String>();
		ResourceQC qc = new ResourceQC();
		qc.setState(PojoState.NORMAL);
		List<Resource> urlResources = ResourceUtils.findResources(qc);
//		DetachedCriteria criteria = DetachedCriteria.forClass(Resource.class);
//		criteria.add(Restrictions.eq("state", PojoState.NORMAL));
//		List<Object> urlResources = getHibernateTemplate().findByCriteria(criteria);
		for (Object resource : urlResources)
			urlAuthorities.put(((Resource) resource).getValue(), ((Resource) resource).getRoleAuthorities());
		List<Resource> list = loadSysResource();
		for (Resource resource : list)
		{
			if (StringUtils.isEmpty(urlAuthorities.get(resource.getValue())))
			{
				urlAuthorities.put(resource.getValue(), AuthConst.PUBLIC_AUTHORITY_ROLE_ID);
				continue;
			}
			String roleAuthorities = resource.getRoleAuthorities();
			if (roleAuthorities.indexOf(",") >= 0)
				roleAuthorities += ("," + AuthConst.PUBLIC_AUTHORITY_ROLE_ID);
			roleAuthorities = AuthConst.PUBLIC_AUTHORITY_ROLE_ID;
			urlAuthorities.put(resource.getValue(), roleAuthorities);
		}
		return urlAuthorities;
	}

	@Override
	public List<Resource> loadSysResource() {
		ResourceQC qc = new ResourceQC();
		qc.setState(PojoState.SYSTEM);
		List<Resource> res = ResourceUtils.findResources(qc);
//		DetachedCriteria criteria = DetachedCriteria.forClass(Resource.class);
//		criteria.add(Restrictions.eq("state", PojoState.SYSTEM));
//		List<Resource> res = new ArrayList<Resource>();
//		for (Object o : getHibernateTemplate().findByCriteria(criteria)) {
//			res.add((Resource) o);
//		}
		return res;
	}

	@Override
	public List<Role> loadSysRole() {
		RoleQC qc = new RoleQC();
		qc.setState(PojoState.SYSTEM);
		List<Role> ros = RoleUtils.findRoles(qc);
//		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);
//		criteria.add(Restrictions.eq("state", PojoState.SYSTEM));
//		List<Role> ros = new ArrayList<Role>();
//		for (Object o : getHibernateTemplate().findByCriteria(criteria)) {
//			ros.add((Role) o);
//		}
		return ros;
	}
}