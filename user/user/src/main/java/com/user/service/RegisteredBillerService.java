package com.user.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.RegisteredBiller;


public interface RegisteredBillerService extends JpaRepository<RegisteredBiller,Long> {

}
