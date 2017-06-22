package com.daydic.api;

/**
 * Created by kusob on 2017. 5. 12..
 */

import com.daydic.domain.ResponseDto;
import com.daydic.domain.article.Article;
import com.daydic.domain.article.ArticleDetailDto;
import com.daydic.domain.article.ArticleDto;
import com.daydic.domain.article.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "게시물 API", description = "DayDic.ARTICLE Table API", basePath = "/api/article")
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "게시물 작성", notes = "게시물 작성")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseDto saveArticle(@RequestBody Article article) {
        try {
            articleService.saveArticle(ArticleDto.of(article));
            return ResponseDto.ofSuccess("success");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return ResponseDto.ofEmpty();
    }

    @ApiOperation(value = "게시물 삭제", notes = "게시물 삭제")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ResponseDto deleteArticle(@RequestParam(value = "id") Long id) {
        try {
            articleService.delete(id);
            return ResponseDto.ofSuccess("success");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return ResponseDto.ofEmpty();
    }

//    @ApiOperation(value = "게시판 리스트", notes = "게시판 리스트")
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public ArticleListDto list(@ApiParam(value = "현제 게시물 페이지 번호")
//                               @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
//        try {
//            return articleService.findArticleList(currentPage);
//        } catch (Exception e) {
//            log.info(e.getMessage());
//        }
//        return ArticleListDto.empty();
//    }

    @ApiOperation(value = "게시물 읽기", notes = "게시물 읽기")
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ArticleDetailDto read(@ApiParam(value = "게시물 id")
                                 @RequestParam(value = "articleId") Long articleId) {
        try {
            return articleService.findArticle(articleId);
        } catch (Exception e) {
            log.error("article read" + e.getMessage(), e);
        }
        return null;
    }
}
