package com.sjb.api.user.model;

public enum UserSearchType {
    NAME("name"),
    PHONE("phone");

    private final String code;

    private UserSearchType(String code) {
        this.code = code;
    }
}
