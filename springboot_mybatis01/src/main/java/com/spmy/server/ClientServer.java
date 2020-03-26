package com.spmy.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration指定当前类为配置类
 */
@Configuration
public class ClientServer {
    /**
     * @Bean将方法的返回值注入到spring容器中
     */
    @Bean
    public String testClientServer() {
        return "@Configuration指定当前类为配置类，@Bean将方法的返回值注入到容器中";
    }
}
