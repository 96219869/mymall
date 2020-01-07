package com.macro.mall.tiny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macro.mall.tiny.mbg.mapper.ChatListMapper;
import com.macro.mall.tiny.mbg.mapper.ChatMsgMapper;
import com.macro.mall.tiny.mbg.model.ChatList;
import com.macro.mall.tiny.mbg.model.ChatListExample;
import com.macro.mall.tiny.mbg.model.ChatListExample.Criteria;
import com.macro.mall.tiny.mbg.model.ChatMsg;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.service.ChatService;
import com.macro.mall.tiny.service.UmsAdminService;


@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatMsgMapper chatMsgMapper;
	
	@Autowired
	private ChatListMapper ChatListMapper;
	
	@Autowired
	private UmsAdminService umsAdminService;
	
	@Override
	public int insertMsg(ChatMsg msg) {
		return chatMsgMapper.insertSelective(msg);
	}

	@Override
	public List<ChatList> getChatListsByMyid(Long myid) {
		ChatListExample example = new ChatListExample();
		ChatListExample.Criteria criteria = example.createCriteria();
		criteria.andMyidEqualTo(myid);
		example.setOrderByClause("id desc");
		return ChatListMapper.selectByExample(example);
	}

	@Override
	public ChatList insertChatList(ChatList list) {//传入的list，必须有我的id，和对方的全部信息
		//先判断数据库有没有该list，可以使用数据库unique索引解决
		ChatListExample example = new ChatListExample();
		Criteria criteria = example.createCriteria();
		criteria.andMyidEqualTo(list.getMyid());
		criteria.andTargetidEqualTo(list.getTargetid());
		List<ChatList> res = ChatListMapper.selectByExample(example);
		if(res != null && res.size() > 0) {
			return null;
		}
		
		UmsAdmin me = umsAdminService.getAdminById(list.getMyid());
		ChatList l = new ChatList();
		l.setMyid(list.getTargetid());//把对方的信息设置为my
		l.setMyavator(list.getTargetavator());
		
		l.setTargetid(list.getMyid());//把我的信息设置为对方的
		l.setTargetname(me.getUsername());
		l.setTargetavator(me.getIcon());
		list.setMyavator(me.getIcon());//补充我的头像
		
		ChatListMapper.insertSelective(list);
		ChatListMapper.insertSelective(l);
		return list;
	}

	@Override
	public int updateHaveNew(Long myid, Long targetid, Byte value) {
		ChatList chatList = new ChatList();
		chatList.setHavenew(value);
		ChatListExample example = new ChatListExample();
		Criteria criteria = example.createCriteria();
		criteria.andMyidEqualTo(myid).andTargetidEqualTo(targetid);
		return ChatListMapper.updateByExampleSelective(chatList, example);
	}
	
}
