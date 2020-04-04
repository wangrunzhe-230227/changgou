package com.changgou;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: WangRunZhe
 * Create at:  2020年04月03日 22:52
 * Company:
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient //开启eureka客户端
@MapperScan(basePackages = "com.changgou.dao")// 开启Mapper的通用包扫描
@EnableSwagger2Doc
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
