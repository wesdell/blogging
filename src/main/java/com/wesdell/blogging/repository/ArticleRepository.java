package com.wesdell.blogging.repository;

import com.wesdell.blogging.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticleByAuthor(String author);
    List<Article> findArticleByPublishedAt(LocalDate publishedAt);
}
