package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.ChatMsg;
import com.macro.mall.tiny.mbg.model.ChatMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatMsgMapper {
    long countByExample(ChatMsgExample example);

    int deleteByExample(ChatMsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChatMsg record);

    int insertSelective(ChatMsg record);

    List<ChatMsg> selectByExample(ChatMsgExample example);

    ChatMsg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChatMsg record, @Param("example") ChatMsgExample example);

    int updateByExample(@Param("record") ChatMsg record, @Param("example") ChatMsgExample example);

    int updateByPrimaryKeySelective(ChatMsg record);

    int updateByPrimaryKey(ChatMsg record);
}