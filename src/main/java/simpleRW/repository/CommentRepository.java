package simpleRW.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import simpleRW.entity.Comment;

@Repository
public class CommentRepository {

    @PersistenceContext
    EntityManager em;

    public List<Comment> findComments(Integer articleId) {
        return em.createQuery(
            "select c from Comment c where c.article.id = :articleId", Comment.class
            ).setParameter("articleId", articleId).getResultList();
    }


    public void insertComment(Comment comment) {
            em.persist(comment);
    }


    public void updateComment(Integer commentId, Comment updated) {
        Comment found = em.find(Comment.class, commentId);

        found.update(updated.getBody(), updated.getUpdated_at());
    }

    public Comment findOneComment(Integer commentId) {
        return em.find(Comment.class, commentId);
    }

    public void deleteComment(Integer commentId) {
        Comment comment = em.find(Comment.class, commentId);
        em.remove(comment);
    }
}
