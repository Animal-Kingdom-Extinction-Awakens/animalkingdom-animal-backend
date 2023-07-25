package com.animalkingdom.animal.usecase.rarity;

import com.animalkingdom.animal.dto.RarityDto;
import com.animalkingdom.animal.repository.rarity.FindAllRarityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllRarityUseCase {

    private final FindAllRarityRepository repository;

    public List<RarityDto> execute() {

        return repository.findAll();
    }
}
