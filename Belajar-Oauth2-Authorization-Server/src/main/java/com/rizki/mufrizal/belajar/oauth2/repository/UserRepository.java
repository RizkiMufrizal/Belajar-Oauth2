package com.rizki.mufrizal.belajar.oauth2.repository;

import com.rizki.mufrizal.belajar.oauth2.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Cacheable(value = "user")
    @Query("select u from User u left join fetch u.userRoles pd where u.email = :email")
    public User getUserByUsername(@Param("email") String email);
}
