package com.itheima.service;

import com.itheima.domain.UserInfo;
import com.itheima.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserInfo findByUsername(String username) throws Exception;
}

