/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.controller;

import Springweb.entity.CartItem;
import Springweb.entity.Customers;
import Springweb.entity.Order;
import Springweb.entity.OrderDetail;
import Springweb.entity.Vegetable;
import Springweb.repository.OrderDetailRepository;
import Springweb.repository.OrderRepository;
import Springweb.repository.VegetableRepository;
import Springweb.service.ShoppingCartService;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Home
 */
@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    @Autowired
    private VegetableRepository vegetableRepository;
    
    @Autowired
    ShoppingCartService shoppingCartService;
    
    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    OrderDetailRepository orderDetailRepository;
    
    @GetMapping("/list")
    public String list(Model model)
    {
        Collection<CartItem> ord = shoppingCartService.getCartItem();
        Object[] items = ord.toArray();
        CartItem item = (CartItem) items[0];
        System.out.println(item.getVegetableID());
        model.addAttribute("cartItems", ord);
        model.addAttribute("total", shoppingCartService.getAmount());
        model.addAttribute("noOfItems", shoppingCartService.getCount());
        return "shoppingCart";
    }
    
    @GetMapping("/add/{vegetableID}")
    public String add(@PathVariable("vegetableID") Integer vegetableID)
    {
        
        Optional<Vegetable> veg  = vegetableRepository.findById(vegetableID); 
        if(veg != null)
        {
            Vegetable a = veg.get();            
            CartItem item = new CartItem();
            item.setVegetableName(a.getVegetableName());
            item.setVegetableID(a.getVegetableID());
            item.setPrice(a.getPrice());
            item.setImage(a.getImage());
            item.setQuantity(1);
            shoppingCartService.add(item);
        }
        return "redirect:/shoppingCart/list";
    }
    
    @PostMapping("/save")
    public String save(Model m,@RequestParam int id)
    {
        Order order = new Order();
        LocalDate myObj = LocalDate.now();
        String date = myObj.toString();
        order.setDate(date);
        float amount = (float)shoppingCartService.getAmount();
        order.setTotal(amount);
        Customers customers = new Customers();
        customers.setCustomerID(id);
        order.setCustomers(customers);
        orderRepository.save(order);
        
        Collection<CartItem> ord1 = shoppingCartService.getCartItem();
        Object[] items = ord1.toArray();
        for(int i =0; i<items.length; i++)
        {
            OrderDetail ord = new OrderDetail();
            ord.setOrder(order);
            CartItem item = (CartItem) items[i];
            System.out.println(item);
            Vegetable vegetable = new Vegetable();
            vegetable.setVegetableID(item.getVegetableID());
            ord.setVegetable(vegetable);
            ord.setQuantity(item.getQuantity());
            float price = (float)item.getPrice();
            ord.setPrice(price);
            orderDetailRepository.save(ord);
        }
        return "redirect:/index";       
    }
    
    @GetMapping("remove/{vegetableID}")
    public String remove(@PathVariable("vegetableID") Integer productID)
    {
        shoppingCartService.remove(productID);
        return "redirect:/shoppingCart/list";
    }
    
    @PostMapping("/update")
    public String update(@RequestParam("productID") Integer vegetableID, @RequestParam("quantity") Integer quantity)
    {
        
        shoppingCartService.update(vegetableID, quantity);
        return "redirect:/shoppingCart/list";
    }
    
    @GetMapping("/clear")
    public String clear()
    {
        shoppingCartService.clear();
        return "redirect:/shoppingCart/list";
    }
    
}
