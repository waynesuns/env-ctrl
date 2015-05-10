package com.waynesun.common.web.control;

import org.springframework.stereotype.Controller;

import com.waynesun.pojo.BasePojo;

@Controller
public abstract class AbstractBindController extends SubmissionController
{

	@Override
	public String getSavedView()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEditView()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeletedView()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends BasePojo> getCommandClass()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCommandView()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
