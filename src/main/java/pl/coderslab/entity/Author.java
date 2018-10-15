package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Cannot be null")
    private String firstName;
    @NotBlank(message = "Cannto be null")
    private String lastName;

    public Author(){}
    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName){
        this.firstName =firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setId(long id) {
        this.id = id;
    }
}
