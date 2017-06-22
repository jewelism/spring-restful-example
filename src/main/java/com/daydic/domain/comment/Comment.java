package com.daydic.domain.comment;

/**
 * Created by kusob on 2017. 5. 12..
 */

import com.daydic.domain.article.Article;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@Table(name = "COMMENT")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cid")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "article_id")
    private Long articleId;
    
    private Date date;
    
    private String writer;

    public static Comment of(Article article, String content) {
        return Comment.builder()
                .articleId(article.getId())
                .content(content)
                .build();
    }
}
