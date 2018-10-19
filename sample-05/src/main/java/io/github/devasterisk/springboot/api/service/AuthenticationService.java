package io.github.devasterisk.springboot.api.service;

import io.github.devasterisk.springboot.api.entity.User;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-28
 */
public interface AuthenticationService {

    User authenticate(String token);
}
