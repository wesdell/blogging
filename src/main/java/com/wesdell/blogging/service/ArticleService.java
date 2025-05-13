package com.wesdell.blogging.service;

import com.wesdell.blogging.model.Article;
import com.wesdell.blogging.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public List<Article> getArticlesByAuthor(String author) {
        return articleRepository.findArticleByAuthor(author);
    }

    public List<Article> getArticlesByPublishedDate(LocalDate date) {
        return articleRepository.findArticleByPublishedAt(date);
    }
}
