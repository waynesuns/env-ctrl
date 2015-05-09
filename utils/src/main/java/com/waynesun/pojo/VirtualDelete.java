package com.waynesun.pojo;

/**
 * Title: 宝冶二期<br>
 * Description:<br>
 * Copyright: Copyright &copy; Steel Bright Intelligence 2006<br>
 * Company: 1703 Studio<br>
 * create date：2006-6-21<br>
 * 
 * 提供虚拟删除的支持
 * 
 * @author  
 * @version: 1.0
 */
public interface VirtualDelete
{
	PojoState getState();
	
	void setState(PojoState state);
}
