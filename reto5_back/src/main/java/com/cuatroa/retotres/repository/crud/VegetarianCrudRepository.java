package com.cuatroa.retotres.repository.crud;

import java.util.List;

import com.cuatroa.retotres.model.Vegetarian;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author 
 */
public interface VegetarianCrudRepository extends MongoRepository<Vegetarian, String> {
   //Reto 5
   public List<Vegetarian> findByPriceLessThanEqual(double precio);
    
   //Reto 5
   @Query("{'description':{'$regex':'?0','$options':'i'}}")
   public List<Vegetarian> findByDescriptionLike(String description);
}
