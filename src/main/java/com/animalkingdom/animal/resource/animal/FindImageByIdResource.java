package com.animalkingdom.animal.resource.animal;

import com.animalkingdom.animal.usecase.animal.FindImageByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindImageByIdResource {

    private final FindImageByIdUseCase useCase;

    @GetMapping(value = "/animals/{id}/image", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public byte[] getFindImageById(@PathVariable Integer id) {

        return this.useCase.execute(id);
    }
}
