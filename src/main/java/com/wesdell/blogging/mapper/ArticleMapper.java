package com.wesdell.blogging.mapper;

import com.wesdell.blogging.dto.ArticleDto;
import com.wesdell.blogging.dto.CreateArticleDto;
import com.wesdell.blogging.dto.UpdateArticleDto;
import com.wesdell.blogging.model.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleDto toDto(Article article);
    Article toEntity(CreateArticleDto dto);
    Article toEntity(UpdateArticleDto dto);
}
