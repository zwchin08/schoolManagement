package com.itheima.service;

import com.itheima.pojo.Category;

import java.util.List;

/**
 * ClassName: CategoryService
 * Package: com.itheima.service.impl
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-19 9:18
 * @Version 1.0
 */
public interface CategoryService {
    //新增分类
    void add(Category category);
    //列表查询
    List<Category> list();
    //根据id查询分类
    Category findById(Integer id);
    //更新分类
    void update(Category category);
    //指定删除分类
    void delete(Integer id);
}
