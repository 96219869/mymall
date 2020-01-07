package com.macro.mall.tiny.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
	
	public static Long getId (HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) return null;
		for(Cookie c : cookies) {
			if(c.getName().equals("token")) return Long.parseLong(c.getValue());
		}
		return null;
	}
	
}
