package com.macro.mall.tiny.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.PmsSkuStock;
import com.macro.mall.tiny.service.PmsSkuStockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * sku库存Controller
 * Created by macro on 2018/4/27.
 */
@Controller
@Api(tags = "PmsSkuStockController", description = "sku商品库存管理")
@RequestMapping("/sku")
public class PmsSkuStockController {
    @Autowired
    private PmsSkuStockService skuStockService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsSkuStock>> getList(@PathVariable Long pid, @RequestParam(value = "keyword",required = false) String keyword) {
        List<PmsSkuStock> skuStockList = skuStockService.getList(pid, keyword);
        return CommonResult.success(skuStockList);
    }
    @ApiOperation("批量更新库存信息")
    @RequestMapping(value ="/update/{pid}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long pid,@RequestBody List<PmsSkuStock> skuStockList){
        int count = skuStockService.update(pid,skuStockList);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }
    
    @RequestMapping(value ="/delete/{pid}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long pid){
        int count = skuStockService.delete(pid);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }
    
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody PmsSkuStock pmsSkuStock){
        int count = skuStockService.add(pmsSkuStock);
        if(count>=0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }
}
