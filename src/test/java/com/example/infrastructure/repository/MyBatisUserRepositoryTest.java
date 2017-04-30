package com.example.infrastructure.repository;

import com.example.domain.User;
import com.example.domain.UserRepository;
import com.example.infrastructure.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@MybatisTest
@Import(MyBatisUserRepository.class)
public class MyBatisUserRepositoryTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_get_all_users() throws Exception {
        User created = new User("123", "aisensiy");
        userMapper.insert(created);

        List<User> all = userRepository.getAll();
        assertThat(all.size(), is(1));
        assertThat(all.get(0), is(created));
    }
}
