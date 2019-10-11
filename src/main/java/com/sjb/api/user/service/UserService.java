package com.sjb.api.user.service;

import com.sjb.api.user.dao.mapper.UserMapper;
import com.sjb.api.user.model.User;
import com.sjb.api.user.model.UserSearch;
import com.sjb.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User search(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Transactional
    public User create(String userId, String userName, String mobileNo) {
        User user = userRepository.findByUserId(userId);

        if (user == null) {
            user = new User();
            user.setUserId(userId);
            user.setUserName(userName);
            user.setMobileNo(mobileNo);
            userRepository.save(user);
        }
        return user;
    }

    @Transactional
    public User modify(String userId, String userName, String mobileNo) {
        User user = userRepository.findByUserId(userId);

        if (user != null) {
            user.setUserName(userName);
            user.setMobileNo(mobileNo);
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

    public Long count(UserSearch userSearch) {
        return userRepository.getUserCount(userSearch);
    }
}