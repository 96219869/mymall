package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.ChatList;
import com.macro.mall.tiny.mbg.model.ChatListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatListMapper {
    long countByExample(ChatListExample example);

    int deleteByExample(ChatListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChatList record);

    int insertSelective(ChatList record);

    List<ChatList> selectByExample(ChatListExample example);

    ChatList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChatList record, @Param("example") ChatListExample example);

    int updateByExample(@Param("record") ChatList record, @Param("example") ChatListExample example);

    int updateByPrimaryKeySelective(ChatList record);

    int updateByPrimaryKey(ChatList record);
}