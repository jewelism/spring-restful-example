package com.daydic.domain.article;

/**
 * Created by kusob on 2017. 5. 12..
 */

import com.daydic.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by iljun on 2017-04-14.
 */
@Getter
@Setter
@Builder
public class ArticleDetailDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Date date;
    private List<Comment> commentList;

    public static ArticleDetailDto of(Article article, List<Comment> comment) {
        return ArticleDetailDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .writer(article.getWriter())
                .date(article.getDate())
                .commentList(comment)
                .build();
    }
}
