package com.waynesun.utils.search;

import java.util.List;

import com.waynesun.pojo.User;
import com.waynesun.utils.search.annotation.Index;

/**
 * SOCKO中需要进行全文检索对象的标识接口
 * @author wayne
 *
 */
public interface SearchableObject {
	public static final String OWNER_ID_PERSONAL_SUFFIX = "_personal";
	public static final String OWNER_ID_DELIM = " ";
	public static final String VISITOR_FLAG_FOLLOWER = "_follower";
	/**scope的编号，用以进行访问权限验证*/
	@Index()
	public String getScopeId();
	/**Owner的编号，用以进行访问权限过滤*/
	@Index()
	public String getOwnerId();
	/**Owner的类型，用以进行访问权限过滤*/
	@Index()
	public String getOwnerType();
	/**图标名称*/
	@Index()
	public String getIconName();
	@Index()
	public String getAlias();
	/**被全文检索出以后显示详情信息的页面地址*/
	@Index()
	public String getSearchDetailPagePath();
	/**更新时是否忽略全文检索的更新*/
	public boolean isIgonre(int operateType);
	/**获取标识符*/
	@Index()
	public String getId();
	
	@Index()
	public List<String> getVisitorFlags();
	
	public User getCreateUser(); 
	
	public int getOperateType(int operateType);
}
