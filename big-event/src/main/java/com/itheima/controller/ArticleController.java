package com.itheima.controller;

import com.itheima.pojo.Article;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.ArticleService;
import com.itheima.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * ClassName: ArticleController
 * Package: com.itheima.controller
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-17 14:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //3.1 发布文章
    @PostMapping
    public Result add(@RequestBody @Validated(Article.Add.class) Article article) {
        articleService.add(article);
        return Result.success();
    }

    //3.2 更新文章
    @PutMapping
    public Result update(@RequestBody @Validated(Article.Update.class) Article article) {
        articleService.update(article);
        return Result.success();
    }

    //3.3 获取文章详情

    @GetMapping("/detail")
    public Result<Article> detail(Integer id){
       Article articleInfo = articleService.detail(id);
       return Result.success(articleInfo);
    }

    //3.4 删除文章
    @DeleteMapping
    public Result<Article> delete(Integer id){
        articleService.delete(id);
        return Result.success();
    }

    //3.5 文章列表(条件分页)
    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        PageBean<Article> pb = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(pb);
    }
}
