package io.github.devasterisk.springboot.api.service;

import io.github.devasterisk.springboot.api.entity.User;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-10
 */
public interface UserService {
    // 가입
    User join(String username, String password);
    // 인증 & 개인정보 조회
    User authentication(String authorization);
    // 비밀번호 변경
    User updatePassword(String token, String password);
    // 탈퇴
    void withdraw(String token);
}
