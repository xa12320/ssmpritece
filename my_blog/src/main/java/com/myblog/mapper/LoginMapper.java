package com.myblog.mapper;

import com.myblog.pojo.User;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/10 14:39
 * @Description:
 */
public interface LoginMapper {
    /**
     * 登录
     * @param user
     * @return
     */
    User userLogin(User user);

}
