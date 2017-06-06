package zht.dubbo.demo.client.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import zht.dubbo.demo.api.entity.ToolEntity;
import zht.dubbo.demo.api.service.DemoService;
import zht.dubbo.demo.client.service.DemoQueryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zhuhaitao on 16/5/26.
 * 演示控制器
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    @Autowired
    private DemoQueryService demoQueryService;

    @RequestMapping(value = "/queryList")
    public void queryList(HttpServletRequest request, HttpServletResponse response) {
        List<ToolEntity> list = demoQueryService.queryToolList(DemoService.LICENCE);

        String content = JSONObject.toJSONString(list);
        System.out.println(content); //打印输出

        //写入输出流
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter pw = response.getWriter();
            pw.write(content);
            pw.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
