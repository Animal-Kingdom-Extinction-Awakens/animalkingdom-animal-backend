package com.animalkingdom.animal.usecase.specie;

import com.animalkingdom.animal.domain.Specie;
import com.animalkingdom.animal.domain.mapper.SpecieMapper;
import com.animalkingdom.animal.repository.specie.CreateSpecieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSpecieUseCase {

    private final CreateSpecieRepository repository;

    public void execute(Input input) {

        Specie specie = Specie.builder()
                .name(input.name())
                .description(input.description())
                .build();

        repository.create(SpecieMapper.toEntity(specie));
    }

    public record Input(
            String name,
            String description
    ) {
    }
}
