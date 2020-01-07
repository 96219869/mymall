package com.macro.mall.tiny.service;



import java.util.List;

import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategory;

/**
 * 商品属性分类Service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductAttributeCategoryService {

    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

}
