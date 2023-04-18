/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import Springweb.entity.Customers;
import Springweb.repository.CustomersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DELL
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomersRepository customersReposity;
    @Override
    public Iterable<Customers> findAll()
    {
        return customersReposity.findAll();
    }
    @Override
    public boolean checklogin(String username, String password) {
        Iterable<Customers>  customers=findAll();
        for (Customers customer : customers) {
            if(customer.getUsername().equals(username)&&customer.getPassword().equals(password))
                return true;
        }
        return false;
    }
    /*public static void main(String[] args) {
        CustomerServiceImpl test=new CustomerServiceImpl();
        System.out.println(test.checklogin("a", "b"));
    }*/
}
