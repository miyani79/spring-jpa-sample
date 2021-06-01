package com.miyani.sample.spring.boot.jpa.repository;

import com.miyani.sample.spring.boot.jpa.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, String>
{
}
