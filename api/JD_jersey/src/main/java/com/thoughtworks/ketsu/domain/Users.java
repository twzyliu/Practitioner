package com.thoughtworks.ketsu.domain;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by zyongliu on 22/11/16.
 */
public interface Users {
    Optional<User> create(HashMap<String, Object> info);

    Optional<User> findById(String uid);
}
