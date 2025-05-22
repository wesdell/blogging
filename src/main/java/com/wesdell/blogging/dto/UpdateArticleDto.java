package com.wesdell.blogging.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateArticleDto {
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    private String title;

    @Size(min = 10, message = "Content must be at least 10 characters")
    private String content;

    @Size(min = 3, message = "Author name must be at least 3 characters")
    private String author;
}
