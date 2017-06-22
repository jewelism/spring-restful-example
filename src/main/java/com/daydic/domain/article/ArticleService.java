package com.daydic.domain.article;

/**
 * Created by kusob on 2017. 5. 12..
 */

import com.daydic.domain.comment.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentService commentService;

    @Transactional(readOnly = false)
    public Article saveArticle(ArticleDto articleDto) {
        return articleRepository.save(Article.of(articleDto));
    }

    public List<Article> findAllArticleList() {
        return articleRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void delete(Long id) {
        articleRepository.delete(id);
    }

//    public ArticleListDto findArticleList(int currentPage){
//        return ArticleListDto.of(articleRepository.articleList(currentPage),currentPage, articleRepository.totalCount());
//    }

    public Article findById(Long id){
        return articleRepository.findOne(id);
    }

    public ArticleDetailDto findArticle(Long articleId){
        return ArticleDetailDto.of(articleRepository.findOne(articleId),commentService.findByArticleId(articleId));
    }
}
