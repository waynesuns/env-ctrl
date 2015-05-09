package com.waynesun.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class JsonFactory
{
	private static JsonFactory factory = null;
	private static ObjectMapper mapper = null;
	private static JsonGenerator generator = null;

	public static JsonFactory getInstance()
	{
		if (factory == null)
		{
			mapper = new ObjectMapper();
			mapper.getDeserializationConfig().disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			mapper.getDeserializationConfig().setDateFormat(df);
			mapper.getSerializationConfig().setDateFormat(df);
			return new JsonFactory();
		}
		return factory;
	}

	public ObjectMapper getObjectMapper()
	{
		return mapper;
	}

	public JsonGenerator getJsonGenerator(OutputStream out)
	{
		if (generator == null)
		{
			try
			{
				generator = mapper.getJsonFactory().createJsonGenerator(out, JsonEncoding.UTF8);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return generator;
		}
		return generator;
	}
}
