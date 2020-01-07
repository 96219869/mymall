package com.macro.mall.tiny.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.common.api.IErrorCode;
import com.macro.mall.tiny.common.api.ResultCode;
import com.macro.mall.tiny.common.utils.CookieUtil;
import com.macro.mall.tiny.dao.zhujie.KefuDao;
import com.macro.mall.tiny.mbg.model.ChatList;
import com.macro.mall.tiny.mbg.model.ChatMsg;
import com.macro.mall.tiny.mbg.model.UmsSeller;
import com.macro.mall.tiny.service.ChatService;
import com.macro.mall.tiny.service.SellerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private KefuDao KefuDao;
	
	@Autowired
	ChatService chatService;
	
	@Autowired
	SellerService sellerService;
	
	@ApiOperation(value = "获取聊天列表")
    @RequestMapping(value = "/getChatList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getChatList(HttpServletRequest request) {
		Long myid = CookieUtil.getId(request);
		if(myid == null) return CommonResult.failed(ResultCode.UNAUTHORIZED);
		List<ChatList> res = chatService.getChatListsByMyid(myid);
		if(res != null && res.size() > 0)
			return CommonResult.success(res);
		ChatList list = new ChatList();
		list.setMyid(myid);
		list.setTargetid(new Long(2000));//客服id
		list.setTargetname("客服1");
		list.setTargetavator(null);//客服使用默认头像
		res = new ArrayList<ChatList>();
		res.add(chatService.insertChatList(list));
		return CommonResult.success(res);
    }
	
    @ApiOperation(value = "获取历史聊天记录")
    @RequestMapping(value = "/getHistory", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getHistory(
    		@RequestParam(defaultValue="10") Integer pageSize, 
    		@RequestParam(defaultValue="0") Integer pageNum,
    		Long sendid, Long recid) {
    	return CommonResult.success(KefuDao.getHistoryMsgs(pageSize, pageNum, sendid, recid));
    }
    
    @ApiOperation(value = "联系卖家")
    @RequestMapping(value = "/lianxiSeller", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult lianxiSeller(@RequestBody UmsSeller user, HttpServletRequest request) {
    	Long myid = CookieUtil.getId(request);
    	if(myid == null) return CommonResult.failed(ResultCode.UNAUTHORIZED);
    	if(user.getId() < 4000) //添加客服，这是从导航栏的联系客服点进来的
    	{
    		ChatList list = new ChatList();
    		list.setMyid(myid);
    		list.setTargetid(new Long(2000));//客服id
    		list.setTargetname("客服1");
    		list.setTargetavator(null);//客服使用默认头像
    		chatService.insertChatList(list);
    		return CommonResult.success(null);
    	}
    	ChatList list = new ChatList();
		list.setMyid(myid);
		UmsSeller seller = sellerService.getById(user.getId());
		list.setTargetid(seller.getId());
		list.setTargetname(seller.getUsername());
		list.setTargetavator(seller.getAvator());
    	chatService.insertChatList(list);
    	return CommonResult.success(null);
    }
    
    @ApiOperation(value = "设置已读")
    @RequestMapping(value = "/havenewTo0", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult havenewTo0(@RequestBody ChatList chatList) {
    	return CommonResult.success(chatService.updateHaveNew(chatList.getMyid(), chatList.getTargetid(), new Byte("0")));
    }
}
