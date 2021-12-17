package com.cuatroa.retotres.service;

import com.cuatroa.retotres.model.Vegetarian;
import com.cuatroa.retotres.repository.VegetarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author John Gutierrez
 */
@Service
public class VegetarianService {

    @Autowired
    private VegetarianRepository accesoryRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Vegetarian> getAll() {
        return accesoryRepository.getAll();
    }

    public Optional<Vegetarian> getAccesory(String reference) {
        return accesoryRepository.getAccesory(reference);
    }

    public Vegetarian create(Vegetarian accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return accesoryRepository.create(accesory);
        }
    }

    public Vegetarian update(Vegetarian accesory) {

        if (accesory.getReference() != null) {
            Optional<Vegetarian> accesoryDb = accesoryRepository.getAccesory(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                accesoryRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getAccesory(reference).map(accesory -> {
            accesoryRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    // Reto 5
    public List<Vegetarian> productByPrice(double price) {
        return accesoryRepository.productByPrice(price);
    }

    // Reto 5
    public List<Vegetarian> findByDescriptionLike(String description) {
        return accesoryRepository.findByDescriptionLike(description);
    }
}
