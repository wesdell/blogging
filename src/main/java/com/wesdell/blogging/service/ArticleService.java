package com.wesdell.blogging.service;

import com.wesdell.blogging.model.Article;
import com.wesdell.blogging.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article createArticle(Article article) {
        Optional<Article> optionalArticle = articleRepository.findArticleByAuthor(article.getAuthor());
        if (optionalArticle.isPresent()) {
            throw new IllegalStateException("Author taken");
        }
        return articleRepository.save(article);
    }

    public Optional<Article> updateArticle(Long id, Article updatedArticle) {
        return articleRepository.findById(id).map(article -> {
            article.setTitle(updatedArticle.getTitle());
            article.setContent(updatedArticle.getContent());
            article.setAuthor(updatedArticle.getAuthor());
            article.setPublishedAt(updatedArticle.getPublishedAt());
            return articleRepository.save(article);
        });
    }

    public void deleteArticle(Long id) {
        boolean articleExists = articleRepository.existsById(id);
        if (!articleExists) {
            throw new IllegalStateException("Article does not exist");
        }
        articleRepository.deleteById(id);
    }
}
