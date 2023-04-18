/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Springweb.repository;

import Springweb.entity.OrderDetail;
import Springweb.entity.OrderDetailID;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Home
 */
public interface OrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailID> {
    
}
