package com.waynesun.common.util.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.waynesun.utils.MessageReader;

public class StateEnumSerializer extends JsonSerializer<Enum<?>>
{

	@Override
	public void serialize(Enum<?> value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException
	{
		jgen.writeStartObject();
		jgen.writeFieldName("ordinal");
		jgen.writeNumber(value.ordinal());
		jgen.writeFieldName("name");
		jgen.writeString(value.name());
		jgen.writeFieldName("value");
		if(value.ordinal() != 1)
			jgen.writeString(MessageReader.getMessage("state.enabled"));
		else
			jgen.writeString(MessageReader.getMessage("state.disabled"));
		jgen.writeEndObject();
	}
}
