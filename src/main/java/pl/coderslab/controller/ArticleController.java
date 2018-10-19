package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Controller
public class ArticleController {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    Validator validator;

    @RequestMapping("/add10articles")
    @ResponseBody
    public String add10articles(){
//title //author //category //content //updated

        String[] title = {
                "What's Behind 'Weeping' Virgin Mary Statues?",
                "The Most Interesting Science News Articles of the Week",
                "Last Survivor of Uncontacted Tribe, 'Man of the Hole,Amazon",
                "Conservatives More Likely to Know 'the Meaning of Life",
                "The Science Behind Your (Irrational) Fear of Friday the 13th",
                "Why Are There 9 Supreme Court Justices?",
                "Rescuers Race Against Time to Save Soccer Team Trapped in Thai Cave",
                "Diver Dies During Rescue Efforts for Cave-Trapped Thai Boys",
                "Are These Dots Purple, Blue or Proof That Humans Will Never Be Happy?",
                "9 Absolutely Evil Medical Experiments"
        };
        String[] content = {
                " When I first walked into the apartment on Ridge Street on the Lower East Side of Manhattan, I didn’t " +
                        "see much because the lights were off. It was a long empty room with couches lining the walls. " +
                        "Empty cans and bottles everywhere. At four in the morning all that was left were the remnants of " +
                        "a party. Nothing unusual. A Hasidic Jew was passed out on his back, yarmulke resting on the cushion " +
                        "next to his head. His cell phone was wildly ringing digitized klezmer music from within his wool " +
                        "pants. He lay totally still. I walked toward him, wondering if he was alive. The phone cycled " +
                        "through four more rings before " +
                        "he swiped at his pocket, at which point I let out a sigh of relief.",
                "For many, religion is tedious work. A chore handed down from generation to generation, rewarding only " +
                        "by virtue of its being unpleasant. Few have had a genuine religious experience, something that " +
                        "warrants worship, reverence, time, and faith. I know I haven’t. In Jewish mysticism, God is " +
                        "partially defined by his lack of definition. He is infinite and unknowable, the eternal question " +
                        "mark. I had my first psychedelic experience smoking salvia in a friend’s station wagon " +
                        "when I was 16. I lay screaming with laughter, soaking myself with tears, snot, and drool. " +
                        "I knew that something significant had happened, something that would definitely fit under " +
                        "the “infinite and unknowable” heading." +
                        " But to say that it was a religious experience would be wrong. It was better.",
                " If you want to know the meaning of life, science probably can't help you much better" +
                " If you want to know the meaning of life, science probably can't help you much better" +
                " If you want to know the meaning of life, science probably can't help you much better" +
                " If you want to know the meaning of life, science probably can't help you much better" +
                " If you want to know the meaning of life, science probably can't help you much better" +
                        " than Kermit therd, Kermit says, \"Always be yourself. Never tre of advnt.\")\n",
                " Today is the second (and last) Friday the 13th of the year. Even though the date" +
                " Today is the second (and last) Friday the 13th of the year. Even though the date" +
                " Today is the second (and last) Friday the 13th of the year. Even though the date" +
                " Today is the second (and last) Friday the 13th of the year. Even though the date" +
                " Today is the second (and last) Friday the 13th of the year. Even though the date" +
                        " is known throughout Wes really jue is Right?\n",
                "After a week or so of this, they learned some deeply unsettling news. Their master, a rebel colonel " +
                        "named Charles Mallory, was planning to send them even farther from home, to help build " +
                        "fortifications in North Carolina. That was when the three slaves decided to " +
                        "fortifications in North Carolina. That was when the three slaves decided to " +
                        "fortifications in North Carolina. That was when the three slaves decided to " +
                        "leave the Confederacy and try their luck, just across the water, with the Union.",
                "A Thai soccer team of 12 boys and their soccer coach were trapped in the Tham " +
                        "Luang Nang Non cave near Chiang Rai, Thailand after monsoon rains cae now tr018.Born in Germany, " +
                        "Luang Nang Non cave near Chiang Rai, Thailand after monsoon rains cae now tr018.Born in Germany, " +
                        "Luang Nang Non cave near Chiang Rai, Thailand after monsoon rains cae now tr018.Born in Germany, " +
                        "raised in Montana, now " +
                        "living in New York, comedian Reggie Watts describes his style as “culture sampling.”",
                "Two and half centuries later, in the first spring of the Civil War, Fort Monroe was a lonely Union " +
                        "redoubt in the heart of newly Confederate territory. Its defenders stood on constant guard. " +
                        "Frigates and armed steamers crowded the nearby waters known as Hampton Roads, one of the world’s " +
                        "great natural harbors. Perspiring squads of soldiers hauled giant columbiad cannons from the fort’s " +
                        "wharf up to its stone parapets. Yet history would come to Fort Monroe not amid the thunder of guns " +
                        "and the clash of " +
                        "fleets, but stealthily, under cover of darkness, in a stolen boat.",
                "On May 23, 1861, little more than a month into the Civil War, three young black men rowed across the " +
                        "James River in Virginia and claimed asylum in a Union-held citadel. Fort Monroe, Va., a " +
                        "fishhook-shaped spit of land near the mouth of the Chesapeake Bay, had been a military post " +
                        "fishhook-shaped spit of land near the mouth of the Chesapeake Bay, had been a military post " +
                        "since the time of the first Jamestown settlers. This spot where the slaves took refuge was also, " +
                        "by remarkable coincidence, the spot where slavery first took root, one summer day in 1619, " +
                        "when a Dutch ship landed with some 20 African captives for the fledgling Virginia Colony.",
                "As the minivan’s air conditioning struggles against the humidity, the two Oxitec scientists prepare for " +
                        "the release—a process that, given the Island of Dr. Moreau–level hysteria that sometimes greets " +
                        "Oxitec’s efforts in test sites around the world, is surprisingly low-tech. First, Evangelou pulls " +
                        "out a piece of light sheet metal that’s been shaped into a foot-wide tube. She sticks one end of " +
                        "the tube through a circular hole cut out of the van’s rear window, then fastens the other end in " +
                        "place with Velcro a few inches from the mouth of a small Dyson fan. Next, she takes her seat in " +
                        "the back, next to the fan, opens one of the coolers, and pulls out one of the 30 plastic containers " +
                        "in " +
                        "which the mosquitoes are waiting. Lacroix puts the van in gear, and off they go.",
                "On a Tuesday morning in September, under a sweltering tropical sun on the island of Grand Cayman, " +
                        "140,000 mosquitoes flit around in four large coolers in the back of a gray Toyota minivan. Behind " +
                        "the wheel is Renaud Lacroix, a Ph.D. in biology and medical entomology who works for the British " +
                        "biotechnology company Oxitec. A colleague, Isavella Evangelou, crouches behind him in a tight space" +
                        " next to the coolers. The minivan is idling on the side of a dirt road in West Bay, a quiet neighbo" +
                        "rhood where iguanas and roosters dart in and out of the yards of small homes painted in Caribbean " +
                        "pastels. The time has come for the mosquitoes to fulfill the purpose for which they were genetically" +
                        " engineered: a kamikaze mission to eliminate their own species."
        };
        Random random = new Random();
        for (int i = 0; i<10; i++){
            Article article = new Article();
            article.setTitle(title[i]);
            article.setContent(content[i]);
            String created = LocalDateTime.now().toString();
            article.setCreated(created);
            article.setAuthor(authorDao.findById(Long.valueOf(i)));
            List<Category> arr = new ArrayList<>();
            if(i<3) arr.add(categoryDao.findById(random.nextInt(10)+1));
            if(i<5) arr.add(categoryDao.findById(random.nextInt(10)+1));
            if(i<10) arr.add(categoryDao.findById(random.nextInt(10)+1));
            article.setCategories(arr);
            articleDao.save(article);
        }
        return "10 articles added";
    }

    @RequestMapping("/allarticles")
    public String showAllArticles(Model model){
        List<Article> articles = articleDao.findAll();
        List<Article> withoutDrafts = new ArrayList<>();
        for (Article a:articles){
            if (a.isDraft()==false){
                withoutDrafts.add(a);
            }
        }
        model.addAttribute("articlesD", withoutDrafts);
        return "article/allArticles";
    }

    @GetMapping("/addarticle")
    public String addArticle(Model model){
        model.addAttribute("article", new Article());
        return "article/articleForm";
    }
    @PostMapping("/addarticle")
    public String postAddArticle(@Valid Article article, BindingResult result){
        if (result.hasErrors()){
            return "article/articleForm";
        }
        article.setCreated(LocalDateTime.now().toString());
        articleDao.save(article);
        return "redirect:allarticles";
    }
    @GetMapping("/editarticle/{id}")
    public String editArticle(Model model, @PathVariable long id){
        Article article = articleDao.findById(id);
        article.setId(id);
        model.addAttribute("categoriesInArticle", articleDao.findCatInArt(article));
        model.addAttribute("article", article);
        model.addAttribute("created", article.getCreated());
        return "article/articleEditForm";
    }
    @PostMapping("/editarticle/{id}")
    public String postEditArticle(@Valid Article article, BindingResult result){
        if (result.hasErrors()){
            return "article/articleEditForm";
        }
        article.setUpdated(LocalDateTime.now().toString());
        articleDao.update(article);
        return "redirect:/allarticles";
    }
    @RequestMapping("/deletearticle/{id}")
    public String deleteArticle(@PathVariable long id){
        Article article = articleDao.findById(id);
        articleDao.delete(article);
        return "redirect:/allarticles";
    }

    @ModelAttribute("articles")
    public Collection<Article> articles(){
        List<Article> articles = articleDao.findAll();
        return articles;
    }
    @ModelAttribute("categories")
    public Collection<Category> categories(){
        List<Category> categories = categoryDao.findAll();
        return categories;
    }
    @ModelAttribute("authors")
    public Collection<Author> authors(){
        List<Author> authors = authorDao.findAll();
        return authors;
    }

}
//created updated everytime i edit article. wHY?