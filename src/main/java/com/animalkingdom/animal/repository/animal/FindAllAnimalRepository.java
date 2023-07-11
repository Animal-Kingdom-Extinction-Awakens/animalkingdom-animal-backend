package com.animalkingdom.animal.repository.animal;

import com.animalkingdom.animal.dto.AnimalDto;
import java.util.List;

public interface FindAllAnimalRepository {

    List<AnimalDto> findAll();

}
