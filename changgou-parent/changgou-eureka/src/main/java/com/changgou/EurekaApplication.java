package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: WangRunZhe
 * Create at:  2020年04月03日 21:17
 * Company:
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer //开启Eureka服务
public class EurekaApplication {
    /**
     * 加载启动类，以启动类为当前SpringBoot的配置标准
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
