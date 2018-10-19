package io.github.devasterisk.springboot.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import io.github.devasterisk.springboot.api.entity.User;
import io.github.devasterisk.springboot.api.exception.UnauthorizedException;
import io.github.devasterisk.springboot.api.repository.UserRepository;
import io.github.devasterisk.springboot.api.service.AuthenticationService;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-28
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User authenticate(String token) {
        try {
            // authorization으로부터 type과 credential을 분리
            String[] split = token.split(" ");
            String type = split[0];
            String credential = split[1];

            if ("Basic".equalsIgnoreCase(type)) {
                // credential을 디코딩하여 username과 password를 분리
                String decoded = new String(Base64Utils.decodeFromString(credential));
                String[] usernameAndPassword = decoded.split(":");

                User user = userRepository.findByUsernameAndPassword(usernameAndPassword[0], usernameAndPassword[1]);
                if (user == null)
                    throw new UnauthorizedException("Invalid credentials");
                else
                    return user;

            } else {
                throw new UnauthorizedException("Unsupported type: " + type);

            }

        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
            throw new UnauthorizedException("Invalid credentials");
        }
    }
}
