package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.UmsManager;
import com.macro.mall.tiny.mbg.model.UmsManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsManagerMapper {
    long countByExample(UmsManagerExample example);

    int deleteByExample(UmsManagerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsManager record);

    int insertSelective(UmsManager record);

    List<UmsManager> selectByExample(UmsManagerExample example);

    UmsManager selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsManager record, @Param("example") UmsManagerExample example);

    int updateByExample(@Param("record") UmsManager record, @Param("example") UmsManagerExample example);

    int updateByPrimaryKeySelective(UmsManager record);

    int updateByPrimaryKey(UmsManager record);
}