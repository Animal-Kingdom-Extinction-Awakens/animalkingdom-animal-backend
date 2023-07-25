package com.animalkingdom.animal.usecase.specie;

import com.animalkingdom.animal.dto.SpecieDto;
import com.animalkingdom.animal.repository.specie.FindAllSpecieRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllSpecieUseCase {

    private final FindAllSpecieRepository repository;

    public List<SpecieDto> execute() {

        return repository.findAll();
    }
}
