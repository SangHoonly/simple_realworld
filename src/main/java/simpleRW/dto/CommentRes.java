package simpleRW.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simpleRW.entity.Comment;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRes {
        private Integer id;

        private String body;

        private Date created_at;

        private Date updated_at;

        public static CommentRes toRes(Comment comment) {
                return CommentRes
                    .builder()
                    .id(comment.getId())
                    .body(comment.getBody())
                    .created_at(comment.getCreated_at())
                    .updated_at(comment.getUpdated_at())
                    .build();
        }
}
