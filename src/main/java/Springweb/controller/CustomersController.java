/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;

import Springweb.entity.Customers;
import Springweb.entity.Vegetable;
import Springweb.repository.CustomersRepository;
import Springweb.service.CustomerService;
import java.util.Optional;
import javax.crypto.AEADBadTagException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author caothanh
 */
@Controller
public class CustomersController {
   
    @Autowired
    private CustomersRepository customersReposity;
    /*@Autowired
    private Customers _customerBean;*/
    @Autowired
    private CustomerService customerService;
    
    
    @GetMapping("/customer/register")
    public String register(Model m)
    {
        Customers cus = new Customers();
        m.addAttribute("customer", cus);
        return "customer_register";   
    }
    
    @PostMapping("/customer/save")
    public String save(Model model, @ModelAttribute("customer") Customers customer)
    {
        
        customersReposity.save(customer);
        return "redirect:/customer/login";       
    }
    @GetMapping("/customer/login")
    public String login(Model m)
    {
        return "login"; 
    }    
    @PostMapping("/customer/checklogin")
    public String checkLogin(Model m,@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session)
    {
        /*if(_customerBean.getUsername().equals(username)&&_customerBean.getPassword().equals(password))
            return "redirect:/customer/all";
        else
            return "redirect:/customer/login";*/
        if(customerService.checklogin(username,password))
        {
            session.setAttribute("USERNAME", username);
            Iterable<Customers> cus = customersReposity.findCusByName(username);
            session.setAttribute("CUSTOMERS", cus);
            for (Customers cu : cus) {
                int id=cu.getCustomerID();
                session.setAttribute("CUSID", id);
            }
            return "redirect:../index";
        }
        else
        {
            m.addAttribute("ERROR", "Username or Password incorrect");
            return "login";
        }
    }
    @PostMapping("/customer/update")
    public String update(Model model, @ModelAttribute("customer") Customers customer)
    {
        Optional<Customers> cus = customersReposity.findById(customer.getCustomerID());
        Customers c;
        c = cus.get();
        c.setAddress(customer.getAddress());
        c.setCity(customer.getCity());
        c.setFullname(customer.getFullname());
        customersReposity.save(c);
        return "redirect:/customer/all";
        
    }
    @GetMapping("/customer/all")
    public String showAllCustomer(Model m)
    {
        Iterable<Customers> list = customersReposity.findAll();
        m.addAttribute("data", list);
        return "customer_all";
        
    }
    @GetMapping(value = {"customer/edit/{id}"})
    public String edit(@PathVariable("id") int id, Model model) {
        Optional<Customers> cus = customersReposity.findById(id);
        cus.ifPresent(customer->model.addAttribute("customer", cus));
        //model.addAttribute("customer", cus);
        return "customer_edit";
    }
            
}
