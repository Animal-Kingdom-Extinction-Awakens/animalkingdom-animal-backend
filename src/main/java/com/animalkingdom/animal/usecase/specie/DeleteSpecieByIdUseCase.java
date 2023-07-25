package com.animalkingdom.animal.usecase.specie;

import com.animalkingdom.animal.repository.specie.DeleteSpecieByIdRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteSpecieByIdUseCase {

    private final DeleteSpecieByIdRepository repository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Integer id) {

        this.repository.delete(id);
    }
}
