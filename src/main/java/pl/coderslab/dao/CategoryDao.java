package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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
}
