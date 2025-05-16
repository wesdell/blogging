package com.wesdell.blogging.controller;

import com.wesdell.blogging.dto.ArticleDto;
import com.wesdell.blogging.mapper.ArticleMapper;
import com.wesdell.blogging.model.Article;
import com.wesdell.blogging.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @GetMapping
    public List<ArticleDto> getArticles() {
        return articleService.getAllArticles().stream().map(articleMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id)
            .map(articleMapper::toDto)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ArticleDto createArticle(@RequestBody Article article) {
        return articleMapper.toDto(articleService.createArticle(article));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDto> updateArticle(@PathVariable Long id, @RequestBody Article article) {
        return ResponseEntity.ok(articleMapper.toDto(articleService.updateArticle(id, article)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
