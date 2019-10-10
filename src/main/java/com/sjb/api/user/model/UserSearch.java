package com.sjb.api.user.model;

public class UserSearch {
    private UserSearchType type;
    private String keyword;

    public void setType(UserSearchType type) {
        this.type = type;
    }

    public UserSearchType getType() {
        return type;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
