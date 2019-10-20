package com.PhoneBookApplication.config.swagger;

import org.springframework.context.annotation.Bean;
import static springfox.documentation.builders.PathSelectors.regex;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
 
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	            .apis(RequestHandlerSelectors
	                .basePackage("com.PhoneBookApplication.controller"))
	            .paths(PathSelectors.regex("/.*"))
	            .build().apiInfo(apiEndPointsInfo());
	    }
	    private ApiInfo apiEndPointsInfo() {
	        return new ApiInfoBuilder().title("Phone Book Application REST API")
	            .description("Phone Book Application REST API")
	            .contact(new Contact("Nomvee", "www.nomvee.com", "nomvee@gmail.com"))
	            .license("Apache 2.0")
	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	            .version("1.0.0")
	            .build();
	    }

}
