package com.wesdell.blogging.controller;

import com.wesdell.blogging.model.Article;
import com.wesdell.blogging.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/author")
    public List<Article> getArticlesByAuthor(@RequestParam String name) {
        return articleService.getArticlesByAuthor(name);
    }

    @GetMapping("/date")
    public List<Article> getArticlesByDate(@RequestParam String date) {
        return articleService.getArticlesByPublishedDate(LocalDate.parse(date));
    }
}
