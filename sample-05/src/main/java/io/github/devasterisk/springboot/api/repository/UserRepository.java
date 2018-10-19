package io.github.devasterisk.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import io.github.devasterisk.springboot.api.entity.User;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-10
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}