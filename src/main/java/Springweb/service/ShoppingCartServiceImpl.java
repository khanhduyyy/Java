/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.CartItem;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;



/**
 *
 * @author Home
 */
@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService{
    private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
    
    @Override
    public void add(CartItem item)
    {
        CartItem existedItem = map.get(item.getVegetableID());
        System.out.println(existedItem);
        if(existedItem != null){
            existedItem.setQuantity(item.getQuantity()+existedItem.getQuantity());
            System.out.println(existedItem.getQuantity());
        }
        else
        {
            map.put(item.getVegetableID(), item);
        }
    }
    
    @Override
    public void update(int vegetableID, int quantity)
    {
        CartItem item = map.get(vegetableID);
        item.setQuantity(quantity);
    }

    @Override
    public double getAmount()
    {
        return map.values().stream().mapToDouble(item->item.getQuantity() * item.getPrice()).sum();
    }
    
    @Override
    public int getCount()
    {
        if(map.isEmpty()) return 0;
        return map.values().size();
    }
    
    @Override
    public void remove(int vegetableID)
    {
        map.remove(vegetableID);
    }
    
    @Override
    public Collection<CartItem> getCartItem()
    {
        return map.values();
    }
    
    public void clear()
    {
        map.clear();
    }
    
}
