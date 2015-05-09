package com.fusioninfo.pojo;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fusioninfo.dao.DaoFactory;
import com.fusioninfo.dao.MaintainDao;
import com.fusioninfo.utils.Const;
import com.fusioninfo.utils.SpringContextUtil;
import com.fusioninfo.utils.observer.Observable;
import com.fusioninfo.utils.observer.ObserverParam;
import com.fusioninfo.utils.search.annotation.Index;

public abstract class BasePojo extends Observable implements Serializable
{

	private static final long serialVersionUID = -1572700120142003837L;

	public static final int NOT_USED_HASHCODE = Integer.MIN_VALUE;

	protected final Log logger = LogFactory.getLog(this.getClass());

	private int hashCode = NOT_USED_HASHCODE;
	
	//@SearchableId(index=Index.NOT_ANALYZED,store=Store.YES)
	String id;

	//@SearchableProperty(index=Index.NOT_ANALYZED,store=Store.YES)
	int version;
	@Index()
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getVersion()
	{
		return version;
	}

	public void setVersion(int version)
	{
		this.version = version;
	}

	public int hashCode()
	{
		if (NOT_USED_HASHCODE == this.hashCode)
		{
			if (null == this.getId())
				return super.hashCode();

			String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
			this.hashCode = hashStr.hashCode();

		}
		return this.hashCode;
	}

	public boolean equals(Object obj)
	{
		if (null == obj)
			return false;
		//if (!(ClassUtils.isEquals(obj.getClass(), this.getClass())))
		//	return false;

		BasePojo mObj = (BasePojo) obj;
		if (null == this.getId() || null == mObj.getId())
			return false;
		return (this.getId().equals(mObj.getId()));

	}

	public String toString()
	{
		String str = getClass().getName() + "[id=" + getId() + "]";
		return str;
	}

	public void update()
	{

		this.save();
	}

	public void delete(){
		this.addObserver();
		ObserverParam observerParam = this.getObserverParam(Const.OPERATE_TYPE_DELETE);
		this.notifyChange(observerParam);
//		getDao().remove(this);
	}

	protected void save(){
		this.addObserver();
		int operateType = this.getId()==null?Const.OPERATE_TYPE_CREATE:Const.OPERATE_TYPE_UPDATE;
		ObserverParam observerParam = this.getObserverParam(operateType);
		getMaintainDao().save(this);
		this.notifyChange(observerParam);
	}

	protected MaintainDao getMaintainDao()
	{
		//return DaoFactory.getInstance().getDao();
		return DaoFactory.getInstance().getMaintainDao();
	}
	

	protected ObserverParam getObserverParam(int operateType){
		return new ObserverParam(operateType);
	}
	
	protected BasePojo getOriginalObject(){
		if(this.getId()==null)
			return null;
//		BasePojo pojo = this.getDao().reLoad(this.getClass(), this.getId());
//		if(pojo==null)
//			 pojo = this;
//		return pojo;
		return null;
	}
	
	public String getClassName() {
		return this.getClass().getName();
	}
	
}
