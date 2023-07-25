package com.animalkingdom.animal.usecase.animal;

import com.animalkingdom.animal.domain.Animal;
import com.animalkingdom.animal.domain.Rarity;
import com.animalkingdom.animal.domain.Specie;
import com.animalkingdom.animal.exception.BusinessException;
import com.animalkingdom.animal.exception.ServerException;
import com.animalkingdom.animal.repository.animal.CreateAnimalRepository;
import com.animalkingdom.animal.usecase.helper.AwsBucketHelper;
import com.animalkingdom.animal.usecase.helper.ImageHelper;
import java.io.File;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateAnimalUseCase {

    private final CreateAnimalRepository repository;
    private final AwsBucketHelper awsBucketHelper;

    public void execute(Input input) {

        try {
            ImageHelper imageHelper = new ImageHelper(input.fileImage());
            File file = imageHelper.convertMultipartFileToFile();

            String key = awsBucketHelper.uploadContentToBucket(file, ImageHelper.buildFileName());

            Animal animal = Animal.builder()
                    .name(input.name())
                    .description(input.description())
                    .specie(Specie.builder().id(input.idSpecie).build())
                    .rarity(Rarity.builder().id(input.idRarity).build())
                    .key(key)
                    .build();

            repository.create(animal);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServerException(e.getMessage());
        }
    }

    public record Input(
            String name,
            String description,
            Integer idSpecie,
            Integer idRarity,
            MultipartFile fileImage
    ) {
    }
}
