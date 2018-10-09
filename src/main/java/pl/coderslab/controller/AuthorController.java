package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import java.util.ArrayList;
import java.util.Collection;
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

    @RequestMapping("/findauthor/{id}")
    @ResponseBody
    public String find(@PathVariable long id){
        Author author = authorDao.findById(id);
        return "Author found: "+author.getFirstName()+" "+author.getLastName();
    }
    @RequestMapping("/allauthors")
    public String showAuthors(){
        return "author/allAuthors";
    }

    @GetMapping("/addauthor")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        return "author/authorForm";
    }

    @PostMapping("addauthor")
    public String postAddAuthor(@ModelAttribute Author author){
        authorDao.save(author);
        return "redirect:allauthors";
    }
    @GetMapping("/editauthor/{id}")
    public String editAuthor(@PathVariable long id, Model model){
        Author author = authorDao.findById(id);
        author.setId(id);
        model.addAttribute("author", author);
        return "author/authorEditForm";
    }
    @PostMapping("/editauthor/{id}")
    public String postEditAuthor(@ModelAttribute Author author){
        authorDao.update(author);
        return "redirect:/allauthors";
    }
    @RequestMapping("/deleteauthor/{id}")
    public String delete(@PathVariable long id){
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect:/allauthors";
    }

    @ModelAttribute("authors")
    public Collection<Author> authors(){
        List<Author> authors = authorDao.findAll();
        return authors;
    }
}
////
//wyświetlić listę wszystkich autorów
//    dodać autora
//    usunąć autora
//    edytować autora
//
//    Dla akcji dodawania oraz edycji utwórz formularz.