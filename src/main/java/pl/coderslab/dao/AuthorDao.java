package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Author a){
        entityManager.persist(a);
    }
    public void update(Author a){
        entityManager.merge(a);
    }
    public Author findById(long id){
        return entityManager.find(Author.class, id);
    }
    public void delete(Author a){
        entityManager.remove(entityManager.contains(a) ? a : entityManager.merge(a));
    }
    public List<Author> findAll(){
        Query query = entityManager.createQuery("select a from  Author  a");
        List<Author> authors = query.getResultList();
        return authors;
    }
}
