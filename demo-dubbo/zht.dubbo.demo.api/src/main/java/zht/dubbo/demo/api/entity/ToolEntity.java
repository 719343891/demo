package zht.dubbo.demo.api.entity;

import java.io.Serializable;

/**
 * Created by zhuhaitao on 16/5/26.
 * 演示用的实体类
 */
public class ToolEntity implements Serializable {
    private String name;    //工具名称
    private String version; //版本
    private String website; //网址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
