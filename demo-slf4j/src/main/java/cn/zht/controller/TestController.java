package cn.zht.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhuhaitao on 17/6/6.
 * 测试
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @ResponseBody
    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("servletPath:" + request.getServletPath() + ", Method:" + request.getMethod());

        return "OK";
    }
}
