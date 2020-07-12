package com.config.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 *  Swagger 配置类
 */
@Configuration
// 开启Swagger2的自动配置
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(true)  // 是否显示 swagger-ui.html
                //设置分组
                .groupName("1组")
                .select()   // 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接
                .apis(RequestHandlerSelectors.basePackage("com.modules.controller"))
                /*
                   .any() // 扫描所有，项目中的所有接口都会被扫描到
                   .none() // 不扫描接口
                   // 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
                   withMethodAnnotation(final Class<? extends Annotation> annotation)
                   // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
                   withClassAnnotation(final Class<? extends Annotation> annotation)
                   basePackage(final String basePackage) // 根据包路径扫描接口
                   // 接口扫描过滤 ,只显示 provider下的请求
                   .paths(PathSelectors.ant("/provider/**"))
                 */
                .paths(PathSelectors.ant("/provider/**"))
                .build();
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(true)  // 是否显示 swagger-ui.html
                //设置分组
                .groupName("2组")
                .select()   // 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接
                .apis(RequestHandlerSelectors.basePackage("com.modules.controller"))
                /*
                   .any() // 扫描所有，项目中的所有接口都会被扫描到
                   .none() // 不扫描接口
                   // 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
                   withMethodAnnotation(final Class<? extends Annotation> annotation)
                   // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
                   withClassAnnotation(final Class<? extends Annotation> annotation)
                   basePackage(final String basePackage) // 根据包路径扫描接口
                   // 接口扫描过滤 ,只显示 provider下的请求
                   .paths(PathSelectors.ant("/provider/**"))
                 */
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("3组");
    }

    @Bean //配置docket以配置Swagger具体参数
    public Docket docket(Environment environment) {

        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(of);



        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(false)  // 是否显示 swagger-ui.html
                //设置分组
                .groupName("4组")
                .select()   // 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接
                .apis(RequestHandlerSelectors.basePackage("com.modules.controller"))
                 /*
                    .any() // 扫描所有，项目中的所有接口都会被扫描到
                    .none() // 不扫描接口
                    // 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
                    withMethodAnnotation(final Class<? extends Annotation> annotation)
                    // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
                    withClassAnnotation(final Class<? extends Annotation> annotation)
                    basePackage(final String basePackage) // 根据包路径扫描接口
                    // 接口扫描过滤 ,只显示 provider下的请求
                    .paths(PathSelectors.ant("/provider/**"))
                  */
                .build();
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("联系人名字", "http://goodysr.cn", "联系人邮箱");
        return new ApiInfo(
                "Bill接口", // 标题
                "如何配置Swagger", // 描述
                "v1.0", // 版本
                "组织链接", // 组织链接
                contact, // 联系人信息
                "", // 许可
                "", // 许可连接
                new ArrayList<>()// 扩展
        );
    }


}
