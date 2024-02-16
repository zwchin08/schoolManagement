package com.itheima.service;

import com.itheima.pojo.User;

/**
 * ClassName: UserService
 * Package: com.itheima.service
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-16 13:24
 * @Version 1.0
 */
public interface UserService {
    //根据用户名查询用户
    User findByUserName(String username);
    //注册
    void register(String username, String password);
    //更新
    void update(User user);
    //更新头像
    void updateAvatar(String avatarUrl);
    //更新密码
    void updatePwd(String newPwd);
}
