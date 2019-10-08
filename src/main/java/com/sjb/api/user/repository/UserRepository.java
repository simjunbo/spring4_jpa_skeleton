package com.sjb.api.user.repository;

import com.sjb.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    User findByUserId(String userId);
}
