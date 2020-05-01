package com.thankson.changgou.goods;

import com.thankson.common.components.business.BaseExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot启动类
 *
 * @author Thankson
 * @date 2020年2月20日
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.thankson.changgou.goods.dao"})
@ComponentScan({ "com.thankson.common.components","com.thankson.changgou.goods"})
public class GoodsApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(GoodsApplication.class, args);

        for (String name : applicationContext.getBeanDefinitionNames()) {
            if(name.contains("controller")){
                System.out.println(name);
            }
            if(name.contains("BaseExceptionHandler")){
                System.out.println(name);
            }
        }
    }
}
