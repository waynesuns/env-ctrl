package com.waynesun.common.web.tag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.waynesun.dao.DaoFactory;
import com.waynesun.dao.QueryDao;
import com.waynesun.pojo.PojoState;
import com.waynesun.utils.CollectionUtil;
import com.waynesun.utils.StringUtils;
import com.waynesun.utils.UserUtils;
import com.waynesun.common.biz.cache.AuthConst;
import com.waynesun.common.biz.resource.Button;
import com.waynesun.common.biz.resource.ButtonQC;
import com.waynesun.common.biz.resource.Resource;
import com.waynesun.common.biz.resource.ResourceUtils;
import com.waynesun.common.biz.role.Role;
import com.waynesun.common.biz.user.AbstractUser;

public class TagFunction
{
	public static boolean buttonPermission(String code)
	{
		AbstractUser user = (AbstractUser) UserUtils.getUser();
		if (user == null || StringUtils.isEmpty(code))
			return false;
		ButtonQC qc = new ButtonQC();
		qc.setCode(code);
		qc.setState_not(PojoState.DELETED);
		List<Button> list = ResourceUtils.findButtons(qc);
		if (CollectionUtil.isEmptyOrZero(list))
			return false;
		Button button = list.get(0);
		
//		List<Role> roles = user.getRolesByState();
		
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		Iterator<GrantedAuthority> iterator = authorities.iterator();
		List<String> roleId = new ArrayList<String>();
		while(iterator.hasNext())
		{
			GrantedAuthority authority = iterator.next();
			String id = authority.getAuthority();
			if(!AuthConst.PUBLIC_AUTHORITY_ROLE_ID.equals(id))
				roleId.add(id);
		}
		List<Role> roles = new ArrayList<Role>();
		if(!CollectionUtil.isEmptyOrZero(roleId))
		{
			String[] ids = roleId.toArray(new String[roleId.size()]);
			QueryDao dao = DaoFactory.getInstance().getQueryDao();
			roles = new ArrayList<Role>();
			for (String id : ids) {
				roles.add((Role) dao.get(Role.class, id, true));
			}
		}
		
		if (CollectionUtil.isEmptyOrZero(roles))
			return false;
		Set<Resource> resources = new HashSet<Resource>();
		for (Role role : roles)
		{
			resources.addAll(role.getRoleByState());
		}
		Set<Button> buttons = new HashSet<Button>();
		for (Resource resource : resources)
		{
			if (resource instanceof Button)
				buttons.add((Button) resource);
		}
		if (buttons.contains(button))
			return true;
		return false;
	}
}
