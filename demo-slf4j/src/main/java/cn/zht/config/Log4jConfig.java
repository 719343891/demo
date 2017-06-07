package cn.zht.config;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Created by zhuhaitao on 17/6/7.
 * 配置log4j日志
 */
@Component
public class Log4jConfig {
    static {
        init();
    }

    private static void init() {
        InputStream in = null;
        try {
            /**
             * 日志文件经常是作为资源文件的，maven中资源文件一般独立一个 src/java/resource 文件夹，
             * 资源文件一般是通过getResouce()，getResourceAsStream()获得。如：
             * Test.class.getResource("file3.txt")
             * Test.class.getResource("/file3.txt")
             * Test.class.getClassLoader.getResource("/file3.txt")
             */
            in = Log4jConfig.class.getClassLoader().getResourceAsStream("log/log4j.properties");
            PropertyConfigurator.configure(in);
        }
        catch (Exception e) {
        }
        finally {
            if(in != null) {
                try {
                    in.close();
                }
                catch (Exception e) {
                }
            }
        }
    }
}
