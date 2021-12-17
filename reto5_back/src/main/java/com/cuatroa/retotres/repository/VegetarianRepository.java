package com.cuatroa.retotres.repository;

import com.cuatroa.retotres.model.Vegetarian;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retotres.repository.crud.VegetarianCrudRepository;

/**
 *
 * @author John Gutierrez
 */
@Repository
public class VegetarianRepository {
    @Autowired
    private VegetarianCrudRepository accesoryCrudRepository;

    public List<Vegetarian> getAll() {
        return accesoryCrudRepository.findAll();
    }

    public Optional<Vegetarian> getAccesory(String reference) {
        return accesoryCrudRepository.findById(reference);
    }
    
    public Vegetarian create(Vegetarian accesory) {
        return accesoryCrudRepository.save(accesory);
    }

    public void update(Vegetarian accesory) {
        accesoryCrudRepository.save(accesory);
    }
    
    public void delete(Vegetarian accesory) {
        accesoryCrudRepository.delete(accesory);
    }
      //Reto 5
      public List<Vegetarian> productByPrice(double precio){
        return accesoryCrudRepository.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Vegetarian> findByDescriptionLike(String description){
        return accesoryCrudRepository.findByDescriptionLike(description);
    }
}
