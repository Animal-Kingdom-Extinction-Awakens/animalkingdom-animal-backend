package com.animalkingdom.animal.infrastructure.controller.skill;

import com.animalkingdom.animal.usercase.skill.DeleteSkillUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DeleteSkillController {

    private final DeleteSkillUseCase userCase;

    @DeleteMapping("/skills/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnimal(@PathVariable String id) {

        userCase.execute(new DeleteSkillUseCase.Input(id));
    }
}
