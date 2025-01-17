package cn.sequoiacap.links.web.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author : Liushide
 * @date :2022/4/6 10:58
 * @description : Swagger配置类
 */
@Configuration
public class SwaggerConfig {

    /**
     * swagger设置，基本信息，要解析的接口及路径等
     * @return Docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                //设置通过什么方式定位需要自动生成文档的接口，这里定位方法上的@ApiOperation注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //接口URI路径设置，any是全路径，也可以通过PathSelectors.regex()正则匹配
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 生成接口信息，包括标题、联系人，联系方式等
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3 Links(短链接服务) 接口文档")
                .description("如有疑问，请联系开发工程师 刘士德")
                .contact(new Contact("刘士德", "https://my.oschina.net/lsd", "liushide@qq.com"))
                .version("1.0")
                .build();
    }

}
