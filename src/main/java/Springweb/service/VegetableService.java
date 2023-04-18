
package Springweb.service;

import Springweb.entity.Vegetable;
import Springweb.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * 
 */
@Service
public interface VegetableService {
    @Autowired
    Iterable<Vegetable> findAll();
    List<Vegetable> search(String term);

}
