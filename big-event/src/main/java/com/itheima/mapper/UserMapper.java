package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * ClassName: UserMapper
 * Package: com.itheima.mapper
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-16 13:25
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from big_event.user where username = #{username}")
    User findByUserName(String username);
    //添加
    @Insert("insert into user(username,password,create_time,update_time)"+
    " values(#{username},#{password},now(),now())")
    void add(String username, String password);
    //更新
    @Update("update big_event.user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id}")
    void update(User user);
    //更新头像
    @Update("update big_event.user set user_pic=#{avatarUrl},update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);
    //更改用户密码
    @Update("update big_event.user set password=#{md5String},update_time=now() where id=#{id}")
    void updatePwd(String md5String, Integer id);
}
