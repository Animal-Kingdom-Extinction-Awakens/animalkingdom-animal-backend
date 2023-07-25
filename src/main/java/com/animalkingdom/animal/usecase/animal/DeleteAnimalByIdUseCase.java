package com.animalkingdom.animal.usecase.animal;

import com.animalkingdom.animal.repository.animal.DeleteAnimalByIdRepository;
import com.animalkingdom.animal.repository.animal.FindImageByIdRespository;
import com.animalkingdom.animal.usecase.helper.AwsBucketHelper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAnimalByIdUseCase {

    private final DeleteAnimalByIdRepository repository;
    private final FindImageByIdRespository findImageByIdRespository;
    private final AwsBucketHelper awsBucketHelper;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Integer id) {

        String key = this.findImageByIdRespository.findImageById(id);
        this.repository.deleteAnimalById(id);
        this.awsBucketHelper.deleteObject(key);
    }
}
