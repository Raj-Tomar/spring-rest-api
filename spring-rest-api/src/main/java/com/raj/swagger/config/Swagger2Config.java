package com.raj.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc //NOTE: Only needed in a non-springboot application
@EnableSwagger2
@ComponentScan("com.raj.controller")
public class Swagger2Config {


   @Bean //Don't forget the @Bean annotation
   public Docket customImplementation(){
	   return new Docket(DocumentationType.SWAGGER_2)
			   .select()
			   .apis(RequestHandlerSelectors.any())
			   .paths(PathSelectors.regex("/.*"))
			   .build()
			   .apiInfo(apiInfo());
   }
   
   private ApiInfo apiInfo() {
       return new ApiInfoBuilder()
           .title("Spring Rest API")
           .description("This API is created for learning purpose only.")
           .version("2.0")
           .termsOfServiceUrl("http://terms-of-services.url")
           .license("LICENSE")
           .licenseUrl("http://url-to-license.com")
           .build();
   }
}