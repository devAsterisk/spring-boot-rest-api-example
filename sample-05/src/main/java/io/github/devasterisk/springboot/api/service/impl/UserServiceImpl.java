package io.github.devasterisk.springboot.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.devasterisk.springboot.api.entity.User;
import io.github.devasterisk.springboot.api.exception.AlreadyExistsException;
import io.github.devasterisk.springboot.api.repository.UserRepository;
import io.github.devasterisk.springboot.api.service.UserService;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-10
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 가입
    @Override
    public User join(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null)
            throw new AlreadyExistsException("Duplicate username");

        return userRepository.save(new User(username, password));
    }

    // 비밀번호 변경
    @Override
    public User updatePassword(Integer userId, String newPassword) {
        User user = userRepository.findOne(userId);
        user.setPassword(newPassword);
        return userRepository.save(user);
    }

    // 탈퇴
    @Override
    public void withdraw(Integer userId) {
        userRepository.delete(userId);
    }
}
