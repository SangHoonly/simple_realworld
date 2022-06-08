package simpleRW.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import simpleRW.dto.ArticleDto;
import simpleRW.entity.Article;

@Repository
public class ArticleRepository {

    @PersistenceContext
    EntityManager em;

    public List<Article> findAllArticles() {
        return em.createQuery("select a from Article a", Article.class)
            .getResultList();
    }

    public Article findOneArticle(Integer articleId) {
        return em.find(Article.class, articleId);
    }

    public void insertArticle(Article article) {
        em.persist(article);
    }

    public void updateArticle(Integer articleId, Article updated) {
        Article article = em.find(Article.class, articleId);

        article.update(updated);
    }

    public void delete(Integer articleId) {
        Article article = em.find(Article.class, articleId);
        em.remove(article);
    }
}
