package com.user.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.user.entity.User;

public interface UserService extends JpaRepository<User,Long>  {
	
	@Query("select p from User p where p.LoginId = ?1 and p.Password=?2")
    List<User> checkLogin(Long LoginId, String Password);

}
