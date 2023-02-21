package com.myblog.service.impl;

import com.myblog.mapper.LoginMapper;
import com.myblog.pojo.User;
import com.myblog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/10 14:20
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User userLogin(User user) {
        return loginMapper.userLogin(user);
    }
}
