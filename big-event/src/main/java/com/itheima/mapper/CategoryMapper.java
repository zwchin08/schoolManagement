package com.itheima.mapper;

import com.itheima.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: CategoryMapper
 * Package: com.itheima.mapper
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-19 9:20
 * @Version 1.0
 */
@Mapper
public interface CategoryMapper {
    //添加分类
    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time) " +
            " VALUES (#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);

    //查询所有
    @Select("select * from category where create_user = #{userId}")
    List<Category> list(Integer userId);

    //根据id查询
    @Select("select * from category where id = #{id}")
    Category findById(Integer id);

    //更新详情页
    @Update("update big_event.category set category_name=#{categoryName},category_alias=#{categoryAlias}," +
            " update_time=#{updateTime} where id = #{id}")
    void update(Category category);
    //删除指定分类
    @Delete("delete from category where id=#{id}")
    void delete(Integer id);
}
