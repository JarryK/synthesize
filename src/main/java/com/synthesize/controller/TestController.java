package com.synthesize.controller;


import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.synthesize.base.JsonResult;
import com.synthesize.base.QueryPage;
import com.synthesize.entity.TestEntity;
import com.synthesize.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@Slf4j
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



    @RequestMapping("remove")
    @ResponseBody
    public JsonResult remove(@RequestBody TestEntity testEntity){
        JsonResult result = new JsonResult(400, "失败");
        try{
            if (Validator.isNull(testEntity) || Validator.isNull(testEntity.getId())){
                result.setMsg("无效的表单信息");
                return result;
            }
            boolean b = service.removeById(testEntity.getId());
            if (b){
                result.setCode(200);
                result.setMsg("成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public JsonResult update(@RequestBody TestEntity testEntity){
        JsonResult result = new JsonResult(400, "失败");
        try{
            if (Validator.isNull(testEntity) || Validator.isNull(testEntity.getId())){
                result.setMsg("无效的表单信息");
                return result;
            }
            TestEntity entity = service.getById(testEntity.getId());
            if (Validator.isNull(entity)){
                result.setMsg("无效的表单信息");
                return result;
            }
            if (Validator.isNotNull(testEntity.getName())){
                entity.setName(testEntity.getName());
            }
            if (Validator.isNotNull(testEntity.getRemake())){
                entity.setRemake(testEntity.getRemake());
            }
            if (Validator.isNotNull(testEntity.getType())){
                entity.setType(testEntity.getType());
            }
            boolean b = service.updateById(entity);
            if (b){
                result.setCode(200);
                result.setMsg("成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("query")
    @ResponseBody
    public JsonResult query(@RequestBody QueryPage<TestEntity> info){
        JsonResult result = new JsonResult(400, "失败");
        try{
            TestEntity entity = info.getQuery();
            Integer num = info.getNum();
            Integer size = info.getSize() == 0 ? 10:info.getSize();
            Page<TestEntity> entityPage = new Page<>(num,size);//参数一是当前页，参数二是每页个数
            entityPage.setSearchCount(true);
            QueryWrapper<TestEntity> wrapper = Wrappers.query();
            if(Validator.isNotNull(entity)){
                if (Validator.isNotNull(entity.getId()) && !"".equals(entity.getId())){
                    wrapper.like("id",likeValue(entity.getId()));
                }
                if (Validator.isNotNull(entity.getName()) && !"".equals(entity.getName())){
                    wrapper.like("name",likeValue(entity.getName()));
                }
                if (Validator.isNotNull(entity.getRemake()) && !"".equals(entity.getRemake())){
                    wrapper.like("remake",likeValue(entity.getRemake()));
                }
                if (Validator.isNotNull(entity.getType()) && entity.getType() != null){
                    wrapper.eq("type",entity.getType());
                }
            }
            entityPage = service.page(entityPage, wrapper);
            result.setCode(200);
            result.setMsg("成功");
            result.setData(entityPage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private String likeValue(String value){
        return "%" + value + "%";
    }

}
