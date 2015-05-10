/**
 * 
 */
package com.waynesun.common.web.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.waynesun.dao.DaoFactory;
import com.waynesun.pojo.BasePojo;
import com.waynesun.utils.MessageReader;

/**
 * @author Administrator socko 2011-5-7
 */
@Controller
public abstract class SubmissionController extends LoadController
{
	private Validator[] validators;

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String modify(@PathVariable String id, HttpServletRequest request, Model model)
	{
		if (id == null)
			return getEditView();
		BasePojo pojo = DaoFactory.getInstance().getQueryDao().get(getCommandClass(), id, true);
		model.addAttribute(getCommandKey(), pojo);
		return getEditView();
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.POST)
	@Transactional
	public String addSave(HttpServletRequest request) throws Exception
	{
		BasePojo pojo = createCommand();
		bindAndValidate(request, pojo);
		pojo.update();
		return getSavedView();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@Transactional
	public String modifySave(@PathVariable String id, HttpServletRequest request) throws Exception
	{
		BasePojo pojo = DaoFactory.getInstance().getQueryDao().get(getCommandClass(), id, true);
		bindAndValidate(request, pojo);
		pojo.update();
		return getSavedView();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Transactional
	public String delete(@PathVariable String id, HttpServletRequest request) throws Exception
	{
		BasePojo pojo = DaoFactory.getInstance().getQueryDao().get(getCommandClass(), id, true);
		bindAndValidate(request, pojo);
		pojo.delete();
		return getDeletedView();
	}

	/**
	 * 创建实体类
	 * 
	 * @return 实体
	 * @throws Exception
	 */
	protected <T> BasePojo createCommand() throws Exception
	{
		if (getCommandClass() == null)
		{
			throw new IllegalStateException("Cannot create command without commandClass being set - "
					+ "either set commandClass or (in a form controller) override formBackingObject");
		}

		return BeanUtils.instantiateClass(getCommandClass());
	}

	/**
	 * 绑定参数到实体
	 * 
	 * @param request
	 *            请求
	 * @param command
	 *            实体对象
	 * @return
	 * @throws Exception
	 */
	protected ServletRequestDataBinder bindAndValidate(HttpServletRequest request, Object command) throws Exception
	{
		/*ServletRequestDataBinder binder = BinderUtils.bindAndValidate(request, command, getValidators());
		if (binder.getBindingResult().hasErrors())
			onBindError(binder);*/
		return null;
	}

	/**
	 * 数据绑定错误后，执行的操作，默认抛出绑定异常，子类可以覆盖此方法处理
	 * 
	 * @param request
	 */
	protected void onBindError(DataBinder binder)
	{
		// 如果出现绑定错误
		BindingResult bindResult = binder.getBindingResult();
		List<ObjectError> errors = bindResult.getAllErrors();
		Map<String, String> result = new HashMap<String, String>();

		for (ObjectError objectError : errors)
		{
			String code = objectError.getCode();
			String message = "";
			Object[] objects = objectError.getArguments();
			if (objects.length > 0)
				message = MessageReader.getMessage((String) objects[0]);
			logger.info(code + " " + message);
			result.put(code, message);
		}

		throw new BindErrorException(result);
	}

	public Validator[] getValidators()
	{
		return validators;
	}

	public abstract String getSavedView();

	public abstract String getEditView();

	public abstract String getDeletedView();
}
