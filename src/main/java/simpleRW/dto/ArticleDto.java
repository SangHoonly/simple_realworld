package simpleRW.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simpleRW.entity.Article;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private Integer id;
    private String title;
    private String author;
    private String body;
    private Date created_at;
    private Date updated_at;

    public Article toEntity() {
        return Article.builder()
            .id(id)
            .title(title)
            .author(author)
            .body(body)
            .createdAt(created_at)
            .updatedAt(updated_at)
            .build();
    }

    public static ArticleDto toDto(Article article) {
        return ArticleDto.builder()
            .id(article.getId())
            .title(article.getTitle())
            .author(article.getAuthor())
            .body(article.getBody())
            .created_at(article.getCreatedAt())
            .updated_at(article.getUpdatedAt())
            .build();
    }
}
