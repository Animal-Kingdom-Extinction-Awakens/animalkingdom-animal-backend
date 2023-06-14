package com.animalkingdom.animal.entity.gateway;

import com.animalkingdom.animal.entity.model.Animal;
import java.util.List;
import java.util.Optional;

public interface AnimalGateway {

    /**
     * Create a new animal
     */
    void create(Animal animal);

    /**
     * Update an existing animal
     */
    void update(Animal animal);

    /**
     * Delete an existing animal
     */
    void delete(String id);

    /**
     * Find an animal by id
     * @return Optional<Animal>
     */
    Optional<Animal> findById(String id);

    /**
     * Find all animals
     * @return List<Animal>
     */
    List<Animal> findAll();
}
