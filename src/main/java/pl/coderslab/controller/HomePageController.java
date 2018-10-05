package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping("/articles")
    public String show5articles(Model model){
        List<Article> articles = articleDao.find5articles();
        List<Category> categories = categoryDao.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("articles", articles);
        return "last5articles";
    }
}
//Zadanie 5
//
//    Utwórz kontroler HomePageController, wyświetlający stronę, która wyświetli 5 ostatnio dodanych artykułów.
//    Wyświetlamy tytuł, datę dodania oraz 200 pierwszych znaków danego artykułu.
//    Na stronie wyświetl listę kategorii z możliwością przejścia do listy wszystkich artykułów z tej kategorii.