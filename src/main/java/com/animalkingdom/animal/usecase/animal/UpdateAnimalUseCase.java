package com.animalkingdom.animal.usecase.animal;

import com.animalkingdom.animal.domain.Animal;
import com.animalkingdom.animal.domain.Rarity;
import com.animalkingdom.animal.domain.Specie;
import com.animalkingdom.animal.dto.AnimalDetailDto;
import com.animalkingdom.animal.repository.animal.FindAnimalByIdRepository;
import com.animalkingdom.animal.repository.animal.FindImageByIdRespository;
import com.animalkingdom.animal.repository.animal.UpdateAnimalRepository;
import com.animalkingdom.animal.usecase.helper.AwsBucketHelper;
import com.animalkingdom.animal.usecase.helper.ImageHelper;
import jakarta.transaction.Transactional;
import java.io.File;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UpdateAnimalUseCase {

    private final AwsBucketHelper awsBucketHelper;
    private final UpdateAnimalRepository repository;
    private final FindImageByIdRespository findImageByIdRespository;

    @Transactional(rollbackOn = Exception.class)
    public void execute(Input input) {
        ImageHelper imageHelper = new ImageHelper(input.fileImage());
        File file = imageHelper.convertMultipartFileToFile();

        String image = findImageByIdRespository.findImageById(input.id());

        String key = awsBucketHelper.uploadContentToBucket(file, image);

        Animal animal = Animal.builder()
                .id(input.id())
                .name(input.name())
                .description(input.description())
                .specie(Specie.builder().id(input.idSpecie).build())
                .rarity(Rarity.builder().id(input.idRarity).build())
                .key(key)
                .build();

        repository.update(animal);
    }

    public record Input(
            Integer id,
            String name,
            String description,
            Integer idSpecie,
            Integer idRarity,
            MultipartFile fileImage
    ) {
    }
}
