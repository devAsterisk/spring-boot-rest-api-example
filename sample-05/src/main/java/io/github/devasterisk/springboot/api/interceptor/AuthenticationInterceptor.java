package io.github.devasterisk.springboot.api.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.devasterisk.springboot.api.entity.User;
import io.github.devasterisk.springboot.api.service.AuthenticationService;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-28
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationInterceptor(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        User user = authenticationService.authenticate(token);
        request.setAttribute("user", user);

        return super.preHandle(request, response, handler);
    }
}
