package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao;

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
    @RequestMapping("/deletecategory/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        return "Category deleted: "+category.getName();
    }
}
