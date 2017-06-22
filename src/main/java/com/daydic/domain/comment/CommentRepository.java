package com.daydic.domain.comment;

import com.daydic.domain.common.DayDicRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kusob on 2017. 5. 12..
 */
@Repository
public interface CommentRepository extends DayDicRepository<Comment, Long> {
    void deleteByArticleId(Long articleId);
    int countByArticleId(Long articleId);
    List<Comment> findByArticleId(Long articleId);
}
