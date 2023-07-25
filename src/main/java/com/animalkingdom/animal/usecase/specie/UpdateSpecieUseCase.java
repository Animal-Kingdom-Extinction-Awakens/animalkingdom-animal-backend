package com.animalkingdom.animal.usecase.specie;

import com.animalkingdom.animal.domain.Specie;
import com.animalkingdom.animal.domain.mapper.SpecieMapper;
import com.animalkingdom.animal.repository.specie.UpdateSpecieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateSpecieUseCase {

    private final UpdateSpecieRepository repository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Input input) {

        Specie specie = Specie.builder()
                .id(input.id())
                .name(input.name())
                .description(input.description())
                .build();

        repository.update(SpecieMapper.toEntity(specie));
    }

    public record Input(
            Integer id,
            String name,
            String description
    ) {
    }
}
