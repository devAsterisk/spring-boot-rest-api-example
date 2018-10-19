package io.github.devasterisk.springboot.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.github.devasterisk.springboot.api.interceptor.AuthenticationInterceptor;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-28
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
            .addPathPatterns("/users/me");  // path가 /user/me인 요청에 대해서만 적용
    }
}
