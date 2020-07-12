# SpringBoot
使用springboot2.x 搭建的工程;使用了Druid连接池、Swagger工具，实现双语，模板使用thymeleaf

## 核心依赖
``` bash
  Spring Boot 2.2.1.RELEASE 
  Mybatis 
  Druid连接池 
  thymeleaf 使用了thymeleaf来显示前端页面
```

## 数据库
  bill.sql文件，直接导入就可以
  
  
## SpringBoot 使用拦截器，实现登录与注册
``` bash
  1：创建SpringMvcConfiguer类，实现WebMvcConfigurer接口，实现WebMVC的配置；
  2：在上面类重写，addInterceptors 方法；实现对哪些请求进行拦截；
  3：创建LoginHandlerInterceptor类，实现HandlerInterceptor接口；
  4：在上面类，完成拦截的操作。
```

## SpringBoot 双语
``` bash
  1：创建LocaleResoverLanguage类，实现LocaleResolver接口；
  2：在上面类重写，resolveLocale方法，判断语言请求；
  3：在WebMVC的配置里进行注册；
  4：配置文件，配置引用语言资源，在配置文件i18n目录下存放多语言文件。
```

## SpringBoot 与 Druid 整合
``` bash
  导入包：
  <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.23</version>
  </dependency>
 整合:
  1：配置文件 application.yml ，配置Druid基本信息；
  2：创建DruidConfig 文件，进行配置，开启后台监控，设置过滤器过滤静态文件；
  3：访问后台监控: xxx/druid/login.html
```

## SpringBoot 与 Swagger 整合
``` bash
  导入包：
 <dependency>
     <groupId>io.springfox</groupId>
     <artifactId>springfox-swagger2</artifactId>
     <version>2.9.2</version>
 </dependency>
 <!-- 默认的 swagger 皮肤 -->
 <dependency>
     <groupId>io.springfox</groupId>
     <artifactId>springfox-swagger-ui</artifactId>
     <version>2.9.2</version>
 </dependency>
 整合:
  1：创建SwaggerConfig类，进行配置，配置相关文档信息；
  2：可以设置分组文档，创建不同的docket方法；
  3：常用的文档注解
      @ApiModel("用户实体")   实体类注解
      @ApiModelProperty("用户名")   成员变量注解  
      @Api(tags = "xxx模块说明")	  作用在模块类上
      @ApiOperation("xxx接口说明")	作用在接口方法上
      @ApiModel("xxxPOJO说明")	    作用在模型类上：如VO、BO
      @ApiModelProperty(value = "xxx属性说明",hidden = true)	作用在类方法和属性上，hidden设置为true可以隐藏该属性
      @ApiParam("xxx参数说明")	    作用在参数、方法和字段上，类似@ApiModelProperty
  4：使用其他皮肤
  导入其他包：
  <!-- 引入swagger-bootstrap-ui包 /doc.html-->
  <dependency>
      <groupId>com.github.xiaoymin</groupId>
      <artifactId>swagger-bootstrap-ui</artifactId>
      <version>1.9.1</version>
  </dependency>
  <!-- 引入swagger-ui-layer包 /docs.html-->
  <dependency>
      <groupId>com.github.caspar-chen</groupId>
      <artifactId>swagger-ui-layer</artifactId>
      <version>1.1.3</version>
  </dependency>
  <!-- 引入swagger-ui-layer包 /document.html-->
  <dependency>
      <groupId>com.zyplayer</groupId>
      <artifactId>swagger-mg-ui</artifactId>
      <version>1.0.6</version>
  </dependency>
  5：访问默认皮肤页面：xxx/swagger-ui.html
```
