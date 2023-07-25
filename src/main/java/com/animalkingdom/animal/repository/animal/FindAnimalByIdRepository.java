package com.animalkingdom.animal.repository.animal;

import com.animalkingdom.animal.dto.AnimalDetailDto;

public interface FindAnimalByIdRepository {

    AnimalDetailDto findById(Integer id);
}
