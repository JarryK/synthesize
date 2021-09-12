package com.synthesize.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.synthesize.base.JsonResult;
import com.synthesize.base.QueryPage;
import com.synthesize.entity.TestEntity;
import com.synthesize.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 测试数据表 前端控制器
 * </p>
 *
 * @author dadayu
 * @since 2021-09-11
 */
@Api("test")
@RestController
@RequestMapping("/test-entity")
public class TestController {

    @Autowired
    private ITestService service;

    @ApiOperation(value="append")
    @RequestMapping("append")
    @ResponseBody
    public JsonResult append (){
        JsonResult result = new JsonResult(400, "失败");
        TestEntity entity = new TestEntity();
        entity.setName(UUID.randomUUID().toString());
        entity.setType(1);
        entity.setRemake("忘了写");
        boolean save = service.save(entity);
        if (save){
            result.setCode(200);
            result.setMsg("成功");
            result.setData(entity);
            return result;
        }
        return result;
    }

    @RequestMapping("query")
    public JsonResult query(Map inMap){
        JsonResult result = new JsonResult(400, "失败");

        try{
            TestEntity entity = (TestEntity) MapUtils.getObject(inMap,"query");
            Integer num = MapUtils.getInteger(inMap, "num", 1);
            Integer size = MapUtils.getInteger(inMap, "size", 10);
            Page<TestEntity> entityPage = new Page<>(num,size);//参数一是当前页，参数二是每页个数
            entityPage.setSearchCount(true);
            QueryWrapper<TestEntity> wrapper = Wrappers.query();
            if(entity != null){
                if (!"".equals(entity.getId())){
                    wrapper.like("id",entity.getId());
                }
                if (!"".equals(entity.getName())){
                    wrapper.like("name",entity.getName());
                }
                if (!"".equals(entity.getRemake())){
                    wrapper.like("remake",entity.getRemake());
                }
                if ( entity.getType() != null){
                    wrapper.eq("type",entity.getType());
                }
            }
            entityPage = service.page(entityPage, wrapper);
            entityPage = service.page(entityPage);
            result.setCode(200);
            result.setMsg("成功");
            result.setData(entityPage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
