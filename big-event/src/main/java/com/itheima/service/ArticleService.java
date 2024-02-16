package com.itheima.service;

import com.itheima.pojo.Article;
import com.itheima.pojo.PageBean;

/**
 * ClassName: ArticleService
 * Package: com.itheima.service
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-19 13:24
 * @Version 1.0
 */

public interface ArticleService {
    //新增文章
    void add(Article article);
    //条件列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
    //更新文章
    void update(Article article);
    //获取文章详情
    Article detail(Integer id);
    //删除
    void delete(Integer id);
}
