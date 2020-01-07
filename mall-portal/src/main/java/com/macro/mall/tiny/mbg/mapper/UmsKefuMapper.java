package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.UmsKefu;
import com.macro.mall.tiny.mbg.model.UmsKefuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsKefuMapper {
    long countByExample(UmsKefuExample example);

    int deleteByExample(UmsKefuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsKefu record);

    int insertSelective(UmsKefu record);

    List<UmsKefu> selectByExample(UmsKefuExample example);

    UmsKefu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsKefu record, @Param("example") UmsKefuExample example);

    int updateByExample(@Param("record") UmsKefu record, @Param("example") UmsKefuExample example);

    int updateByPrimaryKeySelective(UmsKefu record);

    int updateByPrimaryKey(UmsKefu record);
}