package com.sjb.api.user.controller;

import com.sjb.api.user.model.User;
import com.sjb.api.user.model.UserSearch;
import com.sjb.api.user.model.UserSearchType;
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

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Long count(@RequestParam("searchType") String searchType,
                      @RequestParam("searchKeyword") String searchKeyword) {
        UserSearch userSearch = new UserSearch();
        userSearch.setType(UserSearchType.valueOf(searchType));
        userSearch.setKeyword(searchKeyword);
        return userService.count(userSearch);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.POST)
    public User create(@PathVariable("userId") String userId,
                       @RequestParam("userName") String userName,
                       @RequestParam("mobileNo") String mobileNo) {
        return userService.create(userId, userName, mobileNo);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.PUT)
    public User modify(@PathVariable("userId") String userId,
                       @RequestParam("userName") String userName,
                       @RequestParam("mobileNo") String mobileNo) {
        return userService.modify(userId, userName, mobileNo);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("userId") String userId) {
        return userService.delete(userId);
    }
}