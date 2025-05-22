package com.wesdell.blogging.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table
@Data
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
}
