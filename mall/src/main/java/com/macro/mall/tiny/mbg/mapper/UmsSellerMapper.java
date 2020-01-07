package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.UmsSeller;
import com.macro.mall.tiny.mbg.model.UmsSellerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsSellerMapper {
    long countByExample(UmsSellerExample example);

    int deleteByExample(UmsSellerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsSeller record);

    int insertSelective(UmsSeller record);

    List<UmsSeller> selectByExample(UmsSellerExample example);

    UmsSeller selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsSeller record, @Param("example") UmsSellerExample example);

    int updateByExample(@Param("record") UmsSeller record, @Param("example") UmsSellerExample example);

    int updateByPrimaryKeySelective(UmsSeller record);

    int updateByPrimaryKey(UmsSeller record);
}