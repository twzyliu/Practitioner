package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
 * Created by zyongliu on 07/12/16.
 */
public interface UserMapper {
    void createUser(@Param("info") HashMap<String, Object> info);

    User findById(@Param("uid") String uid);
}
