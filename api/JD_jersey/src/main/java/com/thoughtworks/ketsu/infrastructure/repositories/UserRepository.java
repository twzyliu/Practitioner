package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.User;
import com.thoughtworks.ketsu.domain.Users;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.UserMapper;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by zyongliu on 07/12/16.
 */
public class UserRepository implements Users {
    @Inject
    UserMapper userMapper;

    @Override
    public Optional<User> create(HashMap<String, Object> info) {
        userMapper.createUser(info);
        return findById(Integer.parseInt(info.getOrDefault("id", "").toString()));
    }

    @Override
    public Optional<User> findById(Integer uid) {
        User user = userMapper.findById(uid);
        return Optional.of(user);
    }

}
