package com.yangwei.www.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于Gson中反序列化时间类型
 * 
 * 
 */
public class DateDeserializer implements JsonDeserializer<Date> {
	/** 用于显示日期时间的格式化对象 */
	public static final SimpleDateFormat TIMESTAMP_FMT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/* (non-Javadoc)
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public Date deserialize(JsonElement json, Type type,
                            JsonDeserializationContext context) throws JsonParseException {
		if (json instanceof JsonPrimitive) {
			String s = json.getAsJsonPrimitive().getAsString();
			if (s == null || s.equals("")) {
				return null;
			} else {
				try {
					return TIMESTAMP_FMT.parse(s);
				} catch (ParseException e) {
					throw new IllegalArgumentException("时间格式有误，无法解析",e);
				}
			}
		} else {
			return null;
		}
	}

}