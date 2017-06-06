package zht.dubbo.demo.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zht.dubbo.demo.api.entity.ToolEntity;
import zht.dubbo.demo.api.service.DemoService;
import zht.dubbo.demo.client.service.DemoQueryService;

import java.util.List;

/**
 * Created by zhuhaitao on 16/5/26.
 * 演示用查询类
 */
@Service("demoQueryService")
public class DemoQueryServiceImpl implements DemoQueryService {

    @Autowired
    private DemoService demoService; //注入dubbo服务

    @Override
    public List<ToolEntity> queryToolList(String licence) {
        return demoService.queryToolList(licence);
    }
}
