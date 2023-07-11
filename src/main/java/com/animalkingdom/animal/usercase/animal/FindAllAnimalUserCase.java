package com.animalkingdom.animal.usercase.animal;

import com.animalkingdom.animal.dto.AnimalDto;
import com.animalkingdom.animal.repository.animal.FindAllAnimalRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindAllAnimalUserCase {

    private final FindAllAnimalRepository repository;

    public List<AnimalDto> execute() {

        return repository.findAll();
    }
}
