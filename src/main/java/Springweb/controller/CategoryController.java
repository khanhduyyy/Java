
package Springweb.controller;

import Springweb.entity.Category;

import Springweb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    
    
    @Autowired CategoryRepository categoryRepository; //
    
    @GetMapping( value = "/category")
    public String getAll(Model model)
    {
        Iterable<Category> list = categoryRepository.findAll();
        model.addAttribute("list", list);
        return "category";
        
        
    }
}
