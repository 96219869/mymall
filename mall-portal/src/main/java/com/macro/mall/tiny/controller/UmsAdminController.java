package com.macro.mall.tiny.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.UmsAdminLoginParam;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.service.UmsAdminService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台用户管理
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam,
    		HttpServletRequest request, HttpServletResponse response) {
    	CommonResult error = CommonResult.failed("账号或密码错误");
    	if(umsAdminLoginParam == null) return error;
    	String name = umsAdminLoginParam.getUsername();
    	String pwd = umsAdminLoginParam.getPassword();
    	if(name == null || pwd == null) return error;
    	UmsAdmin user = adminService.getAdminByUsername(name);
    	if(user == null || !pwd.equals(user.getPassword())) return error;
    	Cookie cookie = new Cookie("token", user.getId()+"");
    	cookie.setPath("/");
    	cookie.setMaxAge(-1);
    	response.addCookie(cookie);//设置cookie
    	return CommonResult.success(user);
    }
    
    @ApiOperation(value = "退出")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout(HttpServletResponse response,HttpServletRequest request) {
    	if(request.getCookies() == null)
    		System.out.println("暂时没有任何cookie");
    	else
    		for(Cookie c : request.getCookies()) System.out.println(c.getName() + " " + c.getValue());
    	
    	Cookie cookie = new Cookie("token", "-1");
    	cookie.setPath("/");
    	cookie.setMaxAge(0);
    	response.addCookie(cookie);
    	return CommonResult.success(null);
    }
    
}
