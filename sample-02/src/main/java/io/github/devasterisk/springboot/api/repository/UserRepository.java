package io.github.devasterisk.springboot.api.repository;

import org.springframework.data.repository.CrudRepository;

import io.github.devasterisk.springboot.api.entity.User;

/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-01
 */
public interface UserRepository extends CrudRepository<User, Integer> {}