package simpleRW.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import simpleRW.dto.CommentReq;
import simpleRW.dto.CommentRes;
import simpleRW.repository.CommentRepository;

@Service
@Transactional
public class CommentService {

    final
    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Map<String, List<CommentRes>> findComments(Integer articleId) {
        Map<String, List<CommentRes>> map = new HashMap<>();

        List<CommentRes> commentRes = commentRepository.findComments(articleId).stream()
            .map(CommentRes::toRes)
            .collect(Collectors.toList());

        map.put("comments", commentRes);

        return map;
    }

    public CommentRes findOneComment(Integer commentId) {
        return CommentRes.toRes(commentRepository.findOneComment(commentId));
    }

    public void insertComment(CommentReq commentReq) {
        commentReq.setCreated_at(new Date());
        commentReq.setUpdated_at(new Date());

        commentRepository.insertComment(commentReq.toEntity());
    }


    public void updateComment(Integer commentId, CommentReq commentReq) {
        commentReq.setUpdated_at(new Date());

        commentRepository.updateComment(commentId, commentReq.toEntity());
    }


    public void deleteComment(Integer commentId) {

        commentRepository.deleteComment(commentId);
    }
}
