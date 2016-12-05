package com.agnc.carthy;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.agnc.carthy.repository.UserRepository;
import com.agnc.carthy.service.ChurchUserDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired private UserRepository userRepository;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceBean());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http
                .authorizeRequests()
                .antMatchers("/resources/**","/css/**","/js/**","/images/**","/font/**")
                .permitAll();
                
        http
        		.authorizeRequests()
        		.antMatchers("/")
        		.permitAll();
        http
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll();
        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .clearAuthentication(true).logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID").invalidateHttpSession(true);
    }

    
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new ChurchUserDetailsService(userRepository);
    }
}
