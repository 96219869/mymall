package com.macro.mall.tiny.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson {
	
	public static String Obj2Json(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();  
		return mapper.writeValueAsString(object);
	}
	
	public static String getId(HttpServletRequest request)  {
		for(Cookie c : request.getCookies()) {
			if(c.getName() == "Token") {
				return c.getValue();
			}
		}
		return 1 + "";
	}
}
