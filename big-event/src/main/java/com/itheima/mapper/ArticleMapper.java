package com.itheima.mapper;

import com.itheima.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: ArticleMapper
 * Package: com.itheima.mapper
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-19 13:25
 * @Version 1.0
 */
@Mapper
public interface ArticleMapper {
    //添加教师
    @Insert("insert into big_event.article (title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "  VALUES (#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime}) ")
    void add(Article article);


    //使用映射文件配置完成条件查询
    List<Article> list(Integer userId, Integer categoryId, String state);

    @Update("update big_event.article set title=#{title},content=#{content},cover_img=#{coverImg},state=#{state},category_id=#{categoryId},update_time=#{updateTime} where id=#{id}")
    void update(Article article);
    @Select("select * from article where id=#{id}")
    Article detail(Integer id);
    @Delete("delete from article where id=#{id}")
    void delete(Integer id);
}
