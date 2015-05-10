/**
 * 
 */
package com.waynesun.common.web.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.view.AbstractView;

import com.waynesun.exception.NoUserException;

/**
 * @author Administrator
 * 
 */
public class SimpleJsonView extends AbstractView {

	/**
	 * Default content type. Overridable as bean property.
	 */
	public static final String DEFAULT_CONTENT_TYPE = "application/json";
	
	public static final String ERRORY_KEY = "errorMessage";
	
	private JsonEncoding encoding = JsonEncoding.UTF8;
	


	private boolean disableCaching = true;
	
	public boolean isDisableCaching()
	{
		return disableCaching;
	}

	public void setDisableCaching(boolean disableCaching)
	{
		this.disableCaching = disableCaching;
	}
	
	public JsonEncoding getEncoding()
	{
		return encoding;
	}

	public void setEncoding(JsonEncoding encoding)
	{
		this.encoding = encoding;
	}

	
	@Override
	protected void prepareResponse(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(getContentType());
		response.setCharacterEncoding(encoding.getJavaName());
		if (disableCaching) {
			response.addHeader("Pragma", "no-cache");
			response.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
			response.addDateHeader("Expires", 1L);
		}
	}


	@Override
	public void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		triggerErrors(model);
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonGenerator generator =
			objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), encoding);
		objectMapper.writeValue(generator, model);
//		JSONObject jo = JSONObject.fromObject(model);
//
//		PrintWriter out = null;
//		response.setCharacterEncoding(getEncoding());
//		out = response.getWriter();
//		System.out.println(jo.toString());
//		out.write(jo.toString());
//		out.flush();
//		out.close();

	}
	
	private void triggerErrors(Map<String, Object> model)
	{
		if(model.containsKey(ERRORY_KEY))
		{
			model.remove("status");
			Object obj = model.get(ERRORY_KEY);
			if(obj instanceof NoUserException)
				model.put("status", "Failed");
			else
				model.put("status", false);
			model.remove(ERRORY_KEY);
			model.put("message", ((Exception)obj).getMessage());
		}
	}

}
