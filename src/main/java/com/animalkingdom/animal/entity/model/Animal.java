package com.animalkingdom.animal.entity.model;

import com.animalkingdom.animal.entity.model.enums.RarityAnimalEnum;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Animal {

    private String id;
    private String name;
    private SpeciesAnimal species;
    private RarityAnimalEnum rarity;
    private List<Skill> listSkill;
}
