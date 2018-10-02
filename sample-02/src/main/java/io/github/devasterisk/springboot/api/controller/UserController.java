package io.github.devasterisk.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.devasterisk.springboot.api.entity.User;
import io.github.devasterisk.springboot.api.repository.UserRepository;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-01
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    // 사용자 이름을 입력받아 새로운 User를 생성하고 그 결과를 반환
    @PostMapping
    public User create(@RequestParam String name) {
        return userRepository.save(new User(name));
    }

    // READ
    // 모든 사용자 리스트를 반환
    @GetMapping
    public Iterable<User> readAll() {
        return userRepository.findAll();
    }

    // READ
    // 해당 ID의 사용자를 반환
    @GetMapping(value = "/{id}")
    public User readOne(@PathVariable Integer id) {
        return userRepository.findOne(id);
    }

    // UPDATE
    // 해당 ID의 사용자 이름을 갱신한 뒤 그 결과를 반환
    @PutMapping(value = "/{id}")
    public User update(@PathVariable Integer id, @RequestParam String name) {
        User user = userRepository.findOne(id);
        user.setName(name);
        return userRepository.save(user);
    }

    // DELETE
    // 해당 ID의 사용자를 삭제
    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        userRepository.delete(id);
    }
}