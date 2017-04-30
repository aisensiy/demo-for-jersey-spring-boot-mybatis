package com.example.infrastructure.repository;

import com.example.domain.User;
import com.example.domain.UserRepository;
import com.example.infrastructure.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyBatisUserRepository implements UserRepository {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.findAll();
    }
}
