package com.mordas.project.telegrambot;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    public Docket swaggerApiDocket() {
        return createDocket("Telegram bot API", null, PathSelectors.regex("^(?!.*(spring-boot|test))/api/.*"));
    }

    @Bean
    public Docket swaggerSpringBootDocket() {
        return createDocket("Internal Spring Boot API", "spring-boot", PathSelectors.regex("/api/spring-boot/.*"));
    }

    private Docket createDocket(String name, String groupName, Predicate<String> selector) {
        ApiInfo apiInfo = new ApiInfoBuilder().title(name).build();
        TypeResolver typeResolver = new TypeResolver();
        AlternateTypeRule rule = AlternateTypeRules.newRule(
                typeResolver.resolve(Collection.class, WildcardType.class),
                typeResolver.resolve(List.class, WildcardType.class));

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .paths(selector)
                .build()
                .directModelSubstitute(LocalDateTime.class, String.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .alternateTypeRules(rule);
        if (groupName != null) {
            docket.groupName(groupName);
        }
        return docket;
    }
}
