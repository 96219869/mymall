package com.macro.mall.tiny.dao;

import java.util.List;

import com.macro.mall.tiny.dto.PmsProductCategoryWithChildrenItem;

/**
 * 商品分类自定义Dao
 * Created by macro on 2018/5/25.
 */
public interface PmsProductCategoryDao {
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
