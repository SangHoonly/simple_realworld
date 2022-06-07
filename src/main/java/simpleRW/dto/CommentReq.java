package simpleRW.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simpleRW.entity.Comment;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentReq {

    private Integer id;

    private String body;

    private ArticleDto articleDto = new ArticleDto();

    private Date created_at;

    private Date updated_at;


    public Comment toEntity() {
        return Comment
            .builder()
            .id(id)
            .body(body)
            .article(articleDto.toEntity())
            .created_at(created_at)
            .updated_at(updated_at)
            .build();
    }
}
