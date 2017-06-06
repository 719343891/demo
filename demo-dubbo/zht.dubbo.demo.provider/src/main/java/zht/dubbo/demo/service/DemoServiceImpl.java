package zht.dubbo.demo.service;

import org.springframework.stereotype.Service;
import zht.dubbo.demo.api.entity.ToolEntity;
import zht.dubbo.demo.api.service.DemoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuhaitao on 16/5/26.
 * Dubbo服务演示
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    public List<ToolEntity> queryToolList(String licence) {
        if(licence == null || !licence.equals(DemoService.LICENCE)) {
            throw new RuntimeException("授权码错误！");
        }

        List<ToolEntity> toolList = new ArrayList<ToolEntity>();

        ToolEntity redis = new ToolEntity();
        redis.setName("Redis");
        redis.setVersion("3.2.0");
        redis.setWebsite("http://redis.io/");
        toolList.add(redis);

        ToolEntity zookeeper = new ToolEntity();
        zookeeper.setName("Zookeeper");
        zookeeper.setVersion("3.4.8");
        zookeeper.setWebsite("http://zookeeper.apache.org/");
        toolList.add(zookeeper);

        ToolEntity dubbo = new ToolEntity();
        dubbo.setName("Dubbo");
        dubbo.setVersion("2.5.3");
        dubbo.setWebsite("http://dubbo.io/");
        toolList.add(dubbo);

        return toolList;
    }

    public List<ToolEntity> queryInfo(String licence, Integer age, List<String> list) {
        if(licence == null || !licence.equals(DemoService.LICENCE)) {
            throw new RuntimeException("授权码错误！");
        }

        List<ToolEntity> toolList = new ArrayList<ToolEntity>();

        ToolEntity dubbo = new ToolEntity();
        dubbo.setName("Dubbo");
        dubbo.setVersion("2.5.3");
        dubbo.setWebsite("http://dubbo.io/");
        toolList.add(dubbo);

        return toolList;
    }
}
