package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    Validator validator;

    @RequestMapping("/add10categories")
    @ResponseBody
    public String add10categories(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("sport", "about sport"));
        categories.add(new Category("gossips", "about celebrieties"));
        categories.add(new Category("science", "about science"));
        categories.add(new Category("word", "news from word"));
        categories.add(new Category("weather", "about weather"));
        categories.add(new Category("politics", "about politics"));
        categories.add(new Category("discovery", "about discoveries"));
        categories.add(new Category("events", "about events"));
        categories.add(new Category("local", "local news"));
        categories.add(new Category("education", "about education"));
        for (Category c: categories){
            categoryDao.save(c);
        }
        return "Ten categories added";
    }
    @RequestMapping("/findcategory/{id}")
    @ResponseBody
    public String find(@PathVariable long id){
        Category category = categoryDao.findById(id);
        return "Category found: "+category.getName();
    }

    @RequestMapping("/allcategories")
    public String showAllCategories(){
        return "allcategories";
    }

    @ModelAttribute("categories")
    public Collection<Category> categories(){
        List<Category> categories = categoryDao.findAll();
        return categories;
    }
    @ModelAttribute("articles")
    public Collection<Article> articles(){
        List<Article> articles = articleDao.findAll();
        return articles;
    }

    @GetMapping("/addcategory")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "categoryform";
    }
    @PostMapping("/addcategory")
    public String proceedAddCategory(@Valid Category category, BindingResult result){
        if (result.hasErrors()){
            return "categoryform";
        }
        categoryDao.save(category);
        return "redirect:allcategories";
    }
    @RequestMapping("/deletecategory/{id}")
    public String delete(@PathVariable long id){
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        return "redirect:/allcategories";
    }
    @GetMapping("/editcategory/{id}")
    public String editCategory(Model model, @PathVariable long id){
        Category category = categoryDao.findById(id);
        category.setId(id);
        model.addAttribute("category", category);
        return "categoryEditForm";
    }
    @PostMapping("/editcategory/{id}")
    public String postEditCategory(@Valid Category category, BindingResult result){
        if (result.hasErrors()){
            return "categoryEditForm";
        }
        categoryDao.update(category);
        return "redirect:/allcategories";
    }
}
