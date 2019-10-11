package com.sjb.api.user.dao.mapper;

import com.sjb.api.user.dao.annotation.BaseMapper;
import com.sjb.api.user.model.UserSearch;

@BaseMapper
public interface UserMapper {
    Long getUserCount(UserSearch userSearch);
}
