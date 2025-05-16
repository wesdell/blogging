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

    public Article createArticle(Article newArticle) {
        return articleRepository.save(newArticle);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        Optional<Article> existingArticle = articleRepository.findById(id);
        if (existingArticle.isEmpty()) {
            throw new IllegalStateException("Article does not exist");
        }
        Article newUpdatedArticle = existingArticle.get();
        newUpdatedArticle.setAuthor(updatedArticle.getAuthor());
        newUpdatedArticle.setTitle(updatedArticle.getTitle());
        newUpdatedArticle.setContent(updatedArticle.getContent());
        return articleRepository.save(newUpdatedArticle);
    }

    public void deleteArticle(Long id) {
        boolean articleExists = articleRepository.existsById(id);
        if (!articleExists) {
            throw new IllegalStateException("Article does not exist");
        }
        articleRepository.deleteById(id);
    }
}
