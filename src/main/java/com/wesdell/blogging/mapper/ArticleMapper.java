package com.wesdell.blogging.mapper;

import com.wesdell.blogging.dto.ArticleDto;
import com.wesdell.blogging.model.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleDto toDto(Article article);
}
