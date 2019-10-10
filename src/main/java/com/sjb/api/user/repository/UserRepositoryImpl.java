package com.sjb.api.user.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sjb.api.user.model.QUser;
import com.sjb.api.user.model.UserSearch;
import com.sjb.api.user.model.UserSearchType;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryImpl implements UserRepositoryCustom {
    private QUser user = QUser.user;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public Long getUserCount(UserSearch userSearch) {
        BooleanBuilder builder = new BooleanBuilder();

        if (userSearch.getType() == UserSearchType.NAME) {
            builder.and(user.userName.eq(userSearch.getKeyword()));
        } else if (userSearch.getType() == UserSearchType.PHONE) {
            builder.and(user.mobileNo.eq(userSearch.getKeyword()));
        }

        return jpaQueryFactory
                .from(user)
                .where(builder)
                .fetchCount();
    }
}
