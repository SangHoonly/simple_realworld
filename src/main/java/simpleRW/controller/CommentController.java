package simpleRW.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simpleRW.annotation.CheckBodyIsNull;
import simpleRW.dto.CommentReq;
import simpleRW.dto.CommentRes;
import simpleRW.service.CommentService;

@RestController
@RequestMapping("/articles/{articleId}/comments")
public class CommentController {

    final
    CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public Map<String, List<CommentRes>> findComments(@PathVariable Integer articleId) {

        return commentService.findComments(articleId);
    }

    @GetMapping("/{commentId}")
    public CommentRes findOneComment(@PathVariable Integer articleId, @PathVariable Integer commentId) {

        return commentService.findOneComment(commentId);
    }

    @CheckBodyIsNull
    @PostMapping
    public String insertComment(@PathVariable Integer articleId, @RequestBody CommentReq commentReq) {

        commentReq.getArticleDto().setId(articleId);

        commentService.insertComment(commentReq);

        return "ok";
    }


    @CheckBodyIsNull
    @PutMapping("/{commentId}")
    public String updateComment(
        @PathVariable Integer commentId,
        @RequestBody CommentReq commentReq,
        @PathVariable String articleId) {

        commentService.updateComment(commentId, commentReq);

        return "ok";
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Integer articleId, @PathVariable Integer commentId) {

        commentService.deleteComment(commentId);
    }
}
