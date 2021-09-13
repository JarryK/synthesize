package com.synthesize.controller;

import cn.hutool.core.lang.Validator;
import com.synthesize.base.JsonResult;
import com.synthesize.utils.BullshitGeneratorUtil;
import io.swagger.annotations.Api;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.synthesize.utils.BullshitGeneratorUtil.genArticle;

/**
 * <b>项目名称：</b>synthesize<br>
 * <b>类所处包：</b>com.synthesize.controller<br>
 * <b>创建人：</b>yuks<br>
 * <b>类描述：</b><br>
 * <b>创建时间：</b>2021/9/13 22:00<br>
 */
@Api("开放接口")
@RestController
public class OpenController {

    @RequestMapping("genBullShitArticle")
    @ResponseBody
    public String genBullShitArticle(@RequestBody Map<String,Object> inMap){
        String centre = MapUtils.getString(inMap,"centre","湾湾的草莓兵就是逊啦");
        Integer length = MapUtils.getInteger(inMap,"length",1000);
        return genArticle(centre,  length);
    }
}
