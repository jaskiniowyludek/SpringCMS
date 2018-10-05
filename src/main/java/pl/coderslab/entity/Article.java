package pl.coderslab.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200)
    private String title;
    @ManyToOne
    private Author author;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();
    @Column(columnDefinition = "TEXT")
    private String content;

    private String created;
    private String updated;

    public Article(){}

    public long getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        LocalDateTime datetime = LocalDateTime.now();
        created = datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        LocalDateTime localDateTime = LocalDateTime.now();
        updated = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        this.updated = updated;
    }
}
