package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;
import pl.coderslab.validator.ValidationArticle;

import javax.validation.groups.Default;
import java.util.Collection;
import java.util.List;

@Controller
public class DraftController {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    Validator validator;

    @RequestMapping("/alldrafts")
    public String showDrafts(){

        return "draft/allDrafts";
    }
    @GetMapping("/addDraft")
    public String addDraft(Model model){
        model.addAttribute("article", new Article());
        return "draft/draftForm";
    }
    @PostMapping("/addDraft")
    public String postAddArticle(@Validated({Default.class}) Article article, BindingResult result){
        if (result.hasErrors()){
            return "draft/draftForm";
        }
        article.setDraft(true);
        articleDao.save(article);
        return "redirect:alldrafts";
    }
    @GetMapping("/editDraft/{id}")
    public String editDraft(Model model, @PathVariable long id){
        Article article = articleDao.findById(id);
        article.setId(id);
        model.addAttribute("article", article);
        return "draft/draftEditForm";
    }
    @PostMapping("/editdraft/{id}")
    public String postEditArticle(@Validated({Default.class}) Article article, BindingResult result){
        if (result.hasErrors()){
            return "draft/draftEditForm";
        }
        articleDao.update(article);
        return "redirect:/alldrafts";
    }
    @RequestMapping("/deletedraft/{id}")
    public String deleteArticle(@PathVariable long id){
        Article article = articleDao.findById(id);
        articleDao.delete(article);
        return "redirect:/alldrafts";
    }
    @ModelAttribute("drafts")
    public Collection<Article> articles(){
        List<Article> drafts = articleDao.findDrafts();
        return drafts;
    }
}


//    Utwórz kontroler DraftController, utwórz w nim akcje, które pozwolą:
//
//    wyświetlić listę wszystkich szkiców
//    dodać szkic
//    usunąć szkic
//    edytować szkic