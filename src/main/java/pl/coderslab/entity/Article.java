package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validator.MaxNumberCategories;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotBlank(message = "Please, type title")
    @Size(max = 200, message = "Max lenght 200!!")
    private String title;
    @ManyToOne
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotEmpty(message = "At least one category")
    @MaxNumberCategories(4)
    private List<Category> categories = new ArrayList<>();
    @Column(columnDefinition = "TEXT")
    @NotNull(message = "Please, type content")
    @Size(min = 300, message = "Min lenght 300!")
    private String content;
    @Column(updatable = false)
    private String created;

    private String updated;

    public Article(){}

    public void setId(long id) {
        this.id = id;
    }

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
