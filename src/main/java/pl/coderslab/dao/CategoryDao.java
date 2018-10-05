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
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Category c){
        entityManager.persist(c);
    }
    public void update(Category c){
        entityManager.merge(c);
    }
    public Category findById(long id){
        return entityManager.find(Category.class, id);
    }
    public void delete(Category c){
        entityManager.remove(entityManager.contains(c) ? c : entityManager.merge(c));
    }
    public List<Category> findAll(){
        Query query = entityManager.createQuery("select c from Category  c");
        List<Category> categories = query.getResultList();
        return categories;
    }
    public List<Article> findArtInCat(Category category){
        Query query = entityManager.createQuery("select a from Article a where :category member of a.categories");
        query.setParameter("category",category);
        List<Article> articles = query.getResultList();
        return articles;
    }
}
//SELECT a.article_id, a.category_id FROM articles as a, article_categories c
// WHERE a.category_id = c.category_id AND
// c.parent_id = (SELECT c.parent_id WHERE c.category_id = 1)