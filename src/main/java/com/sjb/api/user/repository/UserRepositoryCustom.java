package com.sjb.api.user.repository;

import com.sjb.api.user.model.UserSearch;

public interface UserRepositoryCustom {
    Long getUserCount(UserSearch userSearch);
}
