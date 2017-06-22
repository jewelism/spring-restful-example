package com.daydic.domain.article;

/**
 * Created by kusob on 2017. 5. 12..
 */

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleListDto {
    private List<Article> list;
    private int currentPage;
    private int totalCount;

    public static ArticleListDto empty() {
        return ArticleListDto.builder()
                .list(null)
                .currentPage(0)
                .totalCount(0)
                .build();
    }

    public static ArticleListDto of(List<Article> articleDtos, int currentPage, int totalCount) {
        return ArticleListDto.builder()
                .list(articleDtos)
                .currentPage(currentPage)
                .totalCount(totalCount)
                .build();
    }
}
