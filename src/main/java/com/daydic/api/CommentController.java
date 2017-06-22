package com.daydic.api;

/**
 * Created by kusob on 2017. 5. 12..
 */

import com.daydic.domain.ResponseDto;
import com.daydic.domain.comment.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
@Slf4j
@Api(value = "댓글 API", description = "DayDic.COMMENT Table API", basePath = "/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "댓글 작성", notes = "댓글 작성")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseDto save(@ApiParam(value = "게시물 id")
                            @RequestParam(value = "articleId") Long articleId,
                            @ApiParam(value = "내용")
                            @RequestParam(value = "content") String content) {
        try {
            commentService.save(articleId, content);
            return ResponseDto.ofSuccess("댓글 저장 성공");
        } catch (Exception e) {
            log.error("Comment Save " + e.getMessage(), e);
        }
        return ResponseDto.ofFail("댓글 저장 실패");
    }

    @ApiOperation(value = "댓글 삭제", notes = "댓글 삭제")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ResponseDto delete(@ApiParam(value = "게시물 id")
                              @RequestParam(value = "articleId") Long articleId) {
        try {
            commentService.delete(articleId);
            return ResponseDto.ofSuccess("댓글 삭제 성공");
        } catch (Exception e) {
            log.error("Comment delete " + e.getMessage(), e);
        }
        return ResponseDto.ofFail("댓글 삭제 실패");
    }
}
