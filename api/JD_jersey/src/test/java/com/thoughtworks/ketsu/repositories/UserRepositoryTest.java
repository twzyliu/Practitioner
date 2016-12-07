package com.thoughtworks.ketsu.repositories;

import com.thoughtworks.ketsu.domain.User;
import com.thoughtworks.ketsu.infrastructure.repositories.UserRepository;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zyongliu on 07/12/16.
 */
@RunWith(DatabaseTestRunner.class)
public class UserRepositoryTest {
    @Inject
    UserRepository userRepository;

    @Test
    public void should_return_user_when_create_user() throws Exception {
        Optional<User> user = userRepository.create(TestHelper.userInfo);
        assertThat(user.get().getUsername(), is(TestHelper.USERNAME_A));
    }

    @Test
    public void should_return_user_when_find_by_id() throws Exception {
        Optional<User> byId = userRepository.findById(userRepository.create(TestHelper.userInfo).get().getId() +"");
        assertThat(byId.get().getUsername(), is(TestHelper.USERNAME_A));
    }
}
