package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorDao authorDao;

    @RequestMapping("/add10authors")
    @ResponseBody
    public String add10authors(){
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Anna","Kowalska"));
        authors.add(new Author("Alicja","Kurek"));
        authors.add(new Author("Jan","Brzechwa"));
        authors.add(new Author("Zbigniew","Stonoga"));
        authors.add(new Author("Zofia","Nowak"));
        authors.add(new Author("Patrycja","Dziura"));
        authors.add(new Author("Katarzyna","Lato"));
        authors.add(new Author("Adam","Zielak"));
        authors.add(new Author("Bartosz","Lewandowski"));
        authors.add(new Author("Piotr","Dudek"));
        for (Author a: authors){
            authorDao.save(a);
        }
        return "Authors added";
    }

    @RequestMapping("/deleteauthor/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "Author deleted: "+author.getFirstName()+ " "+author.getLastName();
    }

    @RequestMapping("/findauthor/{id}")
    @ResponseBody
    public String find(@PathVariable long id){
        Author author = authorDao.findById(id);
        return "Author found: "+author.getFirstName()+" "+author.getLastName();
    }
}
