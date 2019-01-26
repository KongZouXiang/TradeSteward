package com.yunhe.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EnableSwagger2
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
                .apis(RequestHandlerSelectors.basePackage("com.yunhe"))
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
                .title("贸易管家后台API接口")
                //创建人
                .contact(new Contact("南瞻部洲全员", "http://localhost:8080", ""))
                //版本号
                .version("1.0")
                //描述
                .description("简单优雅的restfun风格")
                .build();
    }
}
