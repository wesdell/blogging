package service;

import com.wesdell.blogging.model.Article;
import com.wesdell.blogging.repository.ArticleRepository;
import com.wesdell.blogging.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {
    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private ArticleService articleService;

    @Test
    public void Given_NoArticlesInRepository_When_GetAllArticles_Then_ReturnEmptyList() {
        when(articleRepository.findAll()).thenReturn(List.of());
        List<Article> articles = articleService.getAllArticles();
        assertTrue(articles.isEmpty());
    }

    @Test
    public void Given_ArticlesInRepository_When_GetArticleById_Then_ReturnArticle() {
        Article article = new Article(
            1L,
            "Title",
            "Content",
            "Author",
            LocalDate.of(2025, 5, 20)
        );
        when(articleRepository.findById(article.getId())).thenReturn(Optional.of(article));
        Optional<Article> foundArticle = articleService.getArticleById(article.getId());
        assertTrue(foundArticle.isPresent());
    }

    @Test
    public void Given_NoArticlesInRepository_When_CreateAnArticle_Then_ReturnAListWithLengthOne() {
        Article article = new Article(
            1L,
            "Title",
            "Content",
            "Author",
            LocalDate.of(2025, 5, 20)
        );
        when(articleRepository.save(article)).thenReturn(article);
        when(articleRepository.findAll()).thenReturn(List.of(article));
        articleService.createArticle(article);
        List<Article> articles = articleService.getAllArticles();
        assertEquals(1, articles.size());
    }

    @Test
    public void Given_AnArticleWithIdOneInRepository_When_UpdateArticleTitle_Then_ReturnAnArticleWithUpdatedTitle() {
        Article originalArticle = new Article(
            1L,
            "Title",
            "Content",
            "Author",
            LocalDate.of(2025, 5, 20)
        );

        Article updatedArticle = new Article(
            1L,
            "New updated title",
            "Content",
            "Author",
            LocalDate.of(2025, 5, 20)
        );
        when(articleRepository.findById(originalArticle.getId())).thenReturn(
            Optional.of(originalArticle));
        when(articleRepository.save(any(Article.class))).thenReturn(updatedArticle);
        Article result = articleService.updateArticle(originalArticle.getId(), updatedArticle);
        assertEquals("New updated title", result.getTitle());
    }
}
