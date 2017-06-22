package com.daydic.domain.article;

/**
 * Created by kusob on 2017. 5. 12..
 */

import lombok.*;

import java.util.Date;

/**
 * Created by iljun on 2017-03-17.
 */
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String content;
    private String title;
    private String writer;
    private Date date;

    public static ArticleDto of(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .content(article.getContent())
                .title(article.getTitle())
                .writer(article.getWriter())
                .date(article.getDate())
                .build();
    }

    public static ArticleDto of(String content, String title, String writer, Date date) {
        return ArticleDto.builder()
                .content(content)
                .title(title)
                .writer(writer)
                .date(date)
                .build();
    }
}
