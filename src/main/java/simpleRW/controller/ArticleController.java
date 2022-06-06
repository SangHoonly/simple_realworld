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
import simpleRW.dto.ArticleDto;
import simpleRW.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public Map<String, List<ArticleDto>> findArticles() {
        return articleService.findAllArticle();
    }

    @GetMapping("/{articleId}")
    public ArticleDto findOneArticle(@PathVariable Integer articleId) {
        return articleService.findOneArticle(articleId);
    }

    @PostMapping
    public String insertArticle(@RequestBody ArticleDto articleDto) {
        articleService.saveArticle(articleDto);
        return "ok";
    }

    @PutMapping
    public String updateArticle(@RequestBody ArticleDto articleDto) {
        articleService.saveArticle(articleDto);
        return "ok";
    }

    @DeleteMapping("/{articleId}")
    public String deleteArticle(@PathVariable Integer articleId) {
        articleService.deleteArticle(articleId);
        return "ok";
    }
}
