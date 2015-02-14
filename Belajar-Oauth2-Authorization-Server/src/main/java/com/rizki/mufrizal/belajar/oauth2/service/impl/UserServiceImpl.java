package com.rizki.mufrizal.belajar.oauth2.service.impl;

import com.rizki.mufrizal.belajar.oauth2.domain.User;
import com.rizki.mufrizal.belajar.oauth2.repository.UserRepository;
import com.rizki.mufrizal.belajar.oauth2.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Transactional(readOnly = false)
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(User user) {
        userRepository.saveAndFlush(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findOne(username);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
