package com.agnc.carthy;



import java.util.Locale;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;



@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        
    }
    
    
    @Bean
    public SessionLocaleResolver localeResolver() {
     SessionLocaleResolver slr = new SessionLocaleResolver();
     slr.setDefaultLocale(Locale.FRANCE); // Set default Locale as FR
     return slr;
    }
     
    @Bean
    public ResourceBundleMessageSource messageSource() {
     ResourceBundleMessageSource source = new ResourceBundleMessageSource();
     source.setBasenames("118n/messages");  // name of the resource bundle 
     source.setUseCodeAsDefaultMessage(true);
     return source;
    }
 
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        return registrationBean;
    }
    
}
