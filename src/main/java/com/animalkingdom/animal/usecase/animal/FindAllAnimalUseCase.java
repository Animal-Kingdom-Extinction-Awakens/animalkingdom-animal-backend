package com.animalkingdom.animal.usecase.animal;

import com.animalkingdom.animal.dto.AnimalDto;
import com.animalkingdom.animal.repository.animal.FindAllAnimalRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllAnimalUseCase {

    private final FindAllAnimalRepository repository;

    public List<AnimalDto> execute() {

        return repository.findAll();
    }
}
