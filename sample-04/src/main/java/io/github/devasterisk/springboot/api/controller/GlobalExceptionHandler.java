package io.github.devasterisk.springboot.api.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.devasterisk.springboot.api.exception.UnauthorizedException;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-11
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    protected ModelAndView handleUnauthorizedException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // 응답헤더에 WWW-Authenticate를 추가
        response.setHeader("WWW-Authenticate", "Basic realm=\"Access to user information\"");

        // ResponseStatusExceptionResolver를 통해 exception을 응답 모델로 변경
        return new ResponseStatusExceptionResolver()
            .resolveException(request, response, handler, ex);
    }
}
