package simpleRW.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import simpleRW.dto.ArticleDto;
import simpleRW.repository.ArticleRepository;

@Service
@Transactional
public class ArticleService {

    ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Map<String, List<ArticleDto>> findAllArticle() {
        Map<String, List<ArticleDto>> articlesMap = new HashMap<>();
        List<ArticleDto> articles = articleRepository.findAllArticles().stream()
            .map(ArticleDto::toDto)
            .collect(Collectors.toList());

        articlesMap.put("articles", articles);

        return articlesMap;
    }

    public ArticleDto findOneArticle(Integer articleId) {
        return ArticleDto.toDto(articleRepository.findOneArticle(articleId));
    }

    public void insertArticle(ArticleDto articleReq) {
        articleReq.setCreated_at(new Date());
        articleReq.setUpdated_at(new Date());

        articleRepository.insertArticle(articleReq.toEntity());
    }

    public void updateArticle(Integer articleId, ArticleDto articleReq) {
        articleReq.setUpdated_at(new Date());

        articleRepository.updateArticle(articleId, articleReq.toEntity());
    }

    public void deleteArticle(Integer articleId) {
        articleRepository.delete(articleId);
    }
}
