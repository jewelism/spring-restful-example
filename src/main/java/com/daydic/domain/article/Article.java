package com.daydic.domain.article;

/**
 * Created by kusob on 2017. 5. 12..
 */

import javax.persistence.*;

import lombok.*;

import java.util.Date;

/**
 * Created by iljun on 2017-03-11.
 */
@Entity
@Getter
@Setter
@Table(name = "\"ARTICLE\"")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aid")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
//    @Lob //DB의 BLOB타입
    private String content;
    
    private String writer;
    private Date date;

    public static Article of(String title, String content, String writer, Date date) {
        return Article.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .date(date)
                .build();
    }

    public static Article of(ArticleDto articleDto) {
        return Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .writer(articleDto.getWriter())
                .date(articleDto.getDate())
                .build();
    }

}
