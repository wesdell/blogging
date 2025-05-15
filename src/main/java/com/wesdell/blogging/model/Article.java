package com.wesdell.blogging.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Article {
    @Id
    @SequenceGenerator(name = "article_sequence", sequenceName = "article_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_sequence")
    private Long id;

    private String title;
    private String content;
    private String author;
    private LocalDate publishedAt;

    public Article() {
    }

    public Article(Long id, String title, String content, String author, LocalDate publishedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishedAt = publishedAt;
    }

    public Article(String title, String content, String author, LocalDate publishedAt) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishedAt = publishedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }
}
