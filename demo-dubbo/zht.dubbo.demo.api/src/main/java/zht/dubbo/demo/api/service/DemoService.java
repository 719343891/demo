package zht.dubbo.demo.api.service;

import zht.dubbo.demo.api.entity.ToolEntity;

import java.util.List;

/**
 * Created by zhuhaitao on 16/5/26.
 * Dubbo服务演示接口
 */
public interface DemoService {
    public final static String LICENCE = "123456789"; //授权码

    /**
     * 查询工具信息集合
     * @param licence  调用服务的授权码
     * @return
     */
    public List<ToolEntity> queryToolList(String licence);

    /**
     * 查询工具信息集合
     * @param licence  调用服务的授权码
     * @return
     */
    public List<ToolEntity> queryInfo(String licence, Integer age, List<String> list);
}
