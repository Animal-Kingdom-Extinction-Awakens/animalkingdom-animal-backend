package com.animalkingdom.animal.entity.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpeciesAnimal {

    private String id;
    private String name;
    private String description;
}
