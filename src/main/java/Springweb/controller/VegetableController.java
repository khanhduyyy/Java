package Springweb.controller;




import Springweb.*;
import Springweb.entity.Category;
import Springweb.entity.Vegetable;
import Springweb.repository.CategoryRepository;
import Springweb.repository.VegetableRepository;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author caothanh
 */
@Controller
public class VegetableController {

    @Autowired
    private VegetableRepository vegtableRepository;
    
    @Autowired CategoryRepository categoryRepository;
    
   /*@GetMapping("/index")
    public String index(Model m)
    {
//        return  vegtableRepository.findAll();
//        //m.addAttribute("data", list);
//        //return "home";
        Iterable<Vegetable> list = vegtableRepository.findAll();
        m.addAttribute("data", list);
        Iterable<Category> listCate = categoryRepository.findAll();
        m.addAttribute("list", listCate);
        return "index";
    }*/
    
    @GetMapping("/index")
    public String getList(Model m) {
        Iterable<Vegetable> list =null;
        list = vegtableRepository.findAll();
        m.addAttribute("data", list);
        Iterable<Category> listCate = categoryRepository.findAll();
        m.addAttribute("list", listCate);
        return "index";
    }
    @GetMapping("/cate")
    public String getCate(Model m,@RequestParam int id) {
        Iterable<Vegetable> list =null;
        list = vegtableRepository.findByCategory(id);
        m.addAttribute("data", list);
        Iterable<Category> listCate = categoryRepository.findAll();
        m.addAttribute("list", listCate);
        return "index";
    }
    @GetMapping("/search")
    public String getSearch(Model m,@RequestParam String name) {
        Iterable<Vegetable> list =null;
        list = vegtableRepository.findByName(name);
        m.addAttribute("data", list);
        Iterable<Category> listCate = categoryRepository.findAll();
        m.addAttribute("list", listCate);
        return "index";
    }
    @GetMapping("/all")
    public String getAll(Model m)
    {
        Iterable<Vegetable> list = vegtableRepository.findAll();
        m.addAttribute("data", list);
        return "home";
        
    }
    
}
