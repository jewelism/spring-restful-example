package com.daydic.domain.comment;

/**
 * Created by kusob on 2017. 5. 12..
 */

import com.daydic.domain.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleService articleService;

    public void save(Long articleId, String content) {
        commentRepository.save(Comment.of(articleService.findById(articleId), content));
    }

    public void delete(Long articleId) {
        commentRepository.deleteByArticleId(articleId);
    }

    public List<Comment> findByArticleId(Long articleId) {
        return commentRepository.findByArticleId(articleId);
    }
}
