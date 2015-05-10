package com.waynesun.common.web.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.tiles.TilesJstlView;

@SuppressWarnings("deprecation")
public class TilesAndJstlView extends TilesJstlView {

	@Override
	protected String prepareForRendering(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (getUrl().startsWith("."))
		{
			return super.prepareForRendering(request, response);
		}
		return getUrl();
	}
	
	

}
