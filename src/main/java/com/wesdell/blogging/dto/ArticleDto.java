package com.wesdell.blogging.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDate publishedAt;
}
