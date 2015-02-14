package com.rizki.mufrizal.belajar.oauth2.service;

import com.rizki.mufrizal.belajar.oauth2.domain.User;

import java.util.List;

public interface UserService {
    public void save(User user);

    public void update(User user);

    public void delete(User user);

    public User getUser(String username);

    public List<User> getUserList();
}
