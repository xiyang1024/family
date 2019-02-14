package com.ycj.family.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashSet;
import java.util.Set;

/**
 * Thymeleaf模板配置
 * @author chuanjieyang
 * @since Feb 13, 2019 11:28:10 AM
 */
@Configuration
public class ThymeleafConfig {


    /**
     * spring资源模板解析器
     * @return
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        //配置模板
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        //使用HTML的模式，也就是支持HTML5的方式，使用data-th-*的H5写法来写thymeleaf的标签语法
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    /**
     * spring模板引擎
     * @return
     */
    @Bean
    public SpringTemplateEngine templateEngine(){
        //模板引擎增加.让模板能够用到sec前缀，获取spring security的内容
        SpringTemplateEngine engine = new SpringTemplateEngine();
        //设置SpringSecurity方言
        SpringSecurityDialect springSecurityDialect = new SpringSecurityDialect();
        Set<IDialect> dialects = new HashSet<>();
        dialects.add(springSecurityDialect);
        engine.setAdditionalDialects(dialects);

        engine.setTemplateResolver(templateResolver());
        engine.setEnableSpringELCompiler(true);//允许在内容中使用springEL表达式
        return engine;
    }

    /**
     * Thymeleaf视图解析器
     * @return
     */
    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }
}
