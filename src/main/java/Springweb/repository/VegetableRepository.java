
package Springweb.repository;


import Springweb.*;
import Springweb.entity.Category;
import Springweb.entity.Vegetable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * 
 */
@Repository
public interface VegetableRepository extends CrudRepository<Vegetable, Integer>{
    @Query(value="SELECT * FROM `vegetable` WHERE `vegetable`.`CatagoryID` = ?1 ",nativeQuery=true)
    Iterable<Vegetable> findByCategory(int id);
    //@Query(value="",nativeQuery=true)
    @Query(value="SELECT * FROM `vegetable` WHERE `vegetable`.`Vegetable_Name` like %?1% ",nativeQuery=true)
    Iterable<Vegetable> findByName(String name);
}
