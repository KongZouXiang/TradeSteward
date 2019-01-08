package com.yunhe.core.config;

import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/*@EnableSwagger2*/

@Configuration
public class Swagger2Config {

    /**
     * <p>
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * </p>
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.yunhe.basicdata.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * <p>
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     * </p>
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot 测试使用 Swagger2 构建RESTful API")
                //创建人
                .contact(new Contact("MarryFeng", "http://www.baidu.com", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}
