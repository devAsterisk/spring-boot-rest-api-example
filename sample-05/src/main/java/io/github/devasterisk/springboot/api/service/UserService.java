package io.github.devasterisk.springboot.api.service;

import io.github.devasterisk.springboot.api.entity.User;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-10
 */
public interface UserService {
    // 가입
    User join(String username, String password);
    // 비밀번호 변경
    User updatePassword(Integer userId, String newPassword);
    // 탈퇴
    void withdraw(Integer userId);
}
