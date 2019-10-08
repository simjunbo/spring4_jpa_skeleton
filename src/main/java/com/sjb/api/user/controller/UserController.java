package com.sjb.api.user.controller;

import com.sjb.api.user.model.User;
import com.sjb.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    public User search(@PathVariable("userId") String userId) {
        return userService.search(userId);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.POST)
    public User create(@PathVariable("userId") String userId,
                       @RequestParam("userName") String userName) {
        return userService.create(userId, userName);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.PUT)
    public User modify(@PathVariable("userId") String userId,
                       @RequestParam("userName") String userName) {
        return userService.modify(userId, userName);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("userId") String userId) {
        return userService.delete(userId);
    }
}