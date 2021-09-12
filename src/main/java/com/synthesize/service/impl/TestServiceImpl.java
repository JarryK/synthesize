package com.synthesize.service.impl;

import com.synthesize.entity.TestEntity;
import com.synthesize.mapper.TestMapper;
import com.synthesize.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试数据表 服务实现类
 * </p>
 *
 * @author dadayu
 * @since 2021-09-11
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestEntity> implements ITestService {

}
