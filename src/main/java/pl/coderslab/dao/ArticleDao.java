package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Article article){
        entityManager.persist(article);
    }
    public void update(Article article){
        entityManager.merge(article);
    }

    public Article findById(long id){
        return entityManager.find(Article.class, id);
    }
    public void delete(Article article){
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public List<Article> find5articles(){
        Query query = entityManager.createQuery("select a from Article a order by a.created desc ");
        query.setMaxResults(5);
        List<Article> articles = query.getResultList();
        return articles;
    }
    public List<Article> findAll(){
        Query query = entityManager.createQuery("select a from Article a");
        List<Article> articles = query.getResultList();
        return articles;
    }
    public List<Category> findCatInArt(Article article){
        Query query = entityManager.createQuery("select c from Category c where :article member of c.articles");
        query.setParameter("article",article);
        List<Category> categories = query.getResultList();
        return categories;
    }

    public List<Article> findDrafts(){
        Query query = entityManager.createQuery("select a from Article a where a.draft = true ");
        List<Article> drafts = query.getResultList();
        return drafts;
    }
}
