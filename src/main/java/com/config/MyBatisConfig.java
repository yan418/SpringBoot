package com.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis的注解 版本相关配置类
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        ConfigurationCustomizer configurationCustomizer = new ConfigurationCustomizer(){
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //开启驼峰命名方式
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
        return configurationCustomizer;
    }

}
