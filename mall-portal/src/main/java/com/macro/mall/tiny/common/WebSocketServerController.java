package com.macro.mall.tiny.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.macro.mall.tiny.common.utils.Jackson;
import com.macro.mall.tiny.mbg.model.ChatMsg;
import com.macro.mall.tiny.service.ChatService;
import com.macro.mall.tiny.service.PmsProductService;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@ServerEndpoint(value = "/Chat/{sendId}/{recId}/{type}")
public class WebSocketServerController {
	private static Map<String, Session> sessions = new HashMap<String, Session>();

	private static ChatService chatService;
	@Autowired
	public void setChatService(ChatService chatService) {
		WebSocketServerController.chatService = chatService;
	}
	
	@OnOpen
	public void OnOpen(Session session, @PathParam(value = "sendId") String sendId, @PathParam("recId") String recId) {
		sessions.putIfAbsent(sendId, session);
	}

	@OnMessage
	public void OnMsg(String msg, @PathParam(value = "sendId") String sendId, @PathParam("recId") String recId) {
		sendTextMsg(msg, sendId, recId);
	}

	@OnClose
	public void OnClose(Session session, @PathParam(value = "sendId") String sendId, @PathParam("recId") String recId)
			throws IOException {
		sessions.remove(sendId, session);
	}

	@OnError
	public void OnError(Throwable e) {
		e.printStackTrace();
	}

	private void sendTextMsg(String msg, String sendId, String recId) {
		System.out.println("----------------发送消息：" + msg);
		System.out.println("----------------大小：" + sessions.size());
		ChatMsg res = new ChatMsg();
		res.setContent(msg);
		res.setSendid(Long.parseLong(sendId));
		res.setRecid(Long.parseLong(recId));
		String res1 = "";
		try {
			res1 = Jackson.Obj2Json(res);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sessions.containsKey(recId))
			sessions.get(recId).getAsyncRemote().sendText(res1);
		else {
			//为对方设置有新消息
			chatService.updateHaveNew(Long.parseLong(recId), Long.parseLong(sendId), new Byte("1"));
		}
		if (sessions.containsKey(sendId))
			sessions.get(sendId).getAsyncRemote().sendText(res1);
//		chatService.insertMsg(res);
	}
}