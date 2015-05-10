package com.waynesun.common.biz.log;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.waynesun.dao.DaoFactory;
import com.waynesun.pojo.User;
import com.waynesun.common.biz.user.AbstractUser;

/**
 * 
 * 系统日志处理器
 * @author wayne
 *
 */
public class SystemLogProcess
{

	private static ConcurrentLinkedQueue<ServiceAccessLog> serviceAccessLogCache = new ConcurrentLinkedQueue<ServiceAccessLog>();
	private static ConcurrentLinkedQueue<OperateLog> operateLogCache = new ConcurrentLinkedQueue<OperateLog>();
	
	public static int THREAD_AMT = 0;
	public static int THREAD_LIMIT = 15;
	
	public static void addServiceAccessLog(ServiceAccessLog log){
		SystemLogProcess.serviceAccessLogCache.offer(log);
	}

	public static void addOperateLog(OperateLog log){
		SystemLogProcess.operateLogCache.offer(log);
	}
	/**
	 * 批量处理接口访问日志
	 * 
	 * @param list
	 */
	public void updateServiceAccessLog()
	{
		//设置默认用户
		com.waynesun.utils.UserUtils.setUser((User) DaoFactory.getInstance().getQueryDao().get(AbstractUser.class, "1", true));
		System.out.println("SystemLogProcess.serviceAccessLogCache:"+SystemLogProcess.serviceAccessLogCache.size());
		ServiceAccessLog log = SystemLogProcess.serviceAccessLogCache.poll();
		while(log!=null){
			log.update();
			log = SystemLogProcess.serviceAccessLogCache.poll();
		}
	}

	/**
	 * 批量处理操作日志
	 * @throws InterruptedException 
	 */
	public void updateOperateLog()
	{
		//设置默认用户
		com.waynesun.utils.UserUtils.setUser((User) DaoFactory.getInstance().getQueryDao().get(AbstractUser.class, "1", true));
		OperateLog log = SystemLogProcess.operateLogCache.poll();
		while(log!=null){
			log.update();
			log = SystemLogProcess.operateLogCache.poll();
		}
	}
	
}