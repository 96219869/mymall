package com.macro.mall.tiny.service;

import java.util.List;

import com.macro.mall.tiny.mbg.model.ChatList;
import com.macro.mall.tiny.mbg.model.ChatMsg;

public interface ChatService {
	
	public int insertMsg(ChatMsg msg);
	
	public List<ChatList> getChatListsByMyid(Long myid);
	
	public ChatList insertChatList(ChatList list);
	
	public int updateHaveNew(Long myid, Long targetid, Byte value);
}
