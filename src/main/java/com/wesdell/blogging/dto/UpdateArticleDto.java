package com.wesdell.blogging.dto;

import jakarta.validation.constraints.Size;

public class UpdateArticleDto {
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    private String title;

    @Size(min = 10, message = "Content must be at least 10 characters")
    private String content;

    @Size(min = 3, message = "Author name must be at least 3 characters")
    private String author;

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
}
