package com.waynesun.common.web.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waynesun.dao.DaoFactory;
import com.waynesun.pojo.BasePojo;
import com.waynesun.pojo.User;

/**
 * 
 * @author Administrator socko 2011-5-25
 */
@Controller
public abstract class LoadController extends AbstractController {
	abstract public Class<? extends BasePojo> getCommandClass();

	private String commandKey = WebConst.COMMAND_KEY;

	public String getCommandKey() {
		return commandKey;
	}

	public abstract String getCommandView();

	@RequestMapping(value = "/{id}")
	public String getCommand(@PathVariable String id, HttpServletRequest request, Model model) {
		BasePojo pojo = DaoFactory.getInstance().getQueryDao().get(getCommandClass(), id, true);
		model.addAttribute(getCommandKey(), pojo);
		return getCommandView();
	}

	public User getUser(HttpServletRequest request) {
		return (User) request.getAttribute(WebConst.KEY_USER);
	}
}