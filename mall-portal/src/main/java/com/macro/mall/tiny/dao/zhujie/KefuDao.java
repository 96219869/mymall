package com.macro.mall.tiny.dao.zhujie;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.macro.mall.tiny.mbg.model.ChatMsg;

public interface KefuDao {
	
	@Select("select * from chat_msg where (sendid=#{sendId} and recid=#{recId}) " + 
			"or (sendid=#{recId} and recid=#{sendId}) " + 
			"ORDER BY id asc")
	public List<ChatMsg> getHistoryMsgs(Integer pageSize, Integer pageNum, Long sendId, Long recId);
}
