package zht.dubbo.demo.client.service;

import zht.dubbo.demo.api.entity.ToolEntity;

import java.util.List;

/**
 * Created by zhuhaitao on 16/5/26.
 * 演示用查询类
 */
public interface DemoQueryService {
    /**
     * 查询工具信息集合
     * @param licence  调用服务的授权码
     * @return
     */
    public List<ToolEntity> queryToolList(String licence);
}
