package com.sjb.api.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sjb.api.user.model.QUser;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryImpl implements UserRepositoryCustom {
    private QUser user = QUser.user;
/*
    @Autowired
    private JPAQueryFactory jpaQueryFactory;*/
}
