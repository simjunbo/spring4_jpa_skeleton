package com.sjb.api.user.service;

import com.sjb.api.user.model.User;
import com.sjb.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User search(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Transactional
    public User create(String userId, String userName) {
        User user = userRepository.findByUserId(userId);

        if (user == null) {
            user = new User();
            user.setUserId(userId);
            user.setUserName(userName);
            userRepository.save(user);
        }
        return user;
    }

    @Transactional
    public User modify(String userId, String userName) {
        User user = userRepository.findByUserId(userId);

        if (user != null) {
            user.setUserName(userName);
            userRepository.save(user);
        }
        return user;
    }

    @Transactional
    public boolean delete(String userId) {
        User user = userRepository.findByUserId(userId);

        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}