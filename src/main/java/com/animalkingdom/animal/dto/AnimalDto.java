package com.animalkingdom.animal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalDto {

    private Integer id;
    private String name;
    private String description;
    private String specie;
    private String rarity;
}
