package com.animalkingdom.animal.entity;

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
public class AnimalEntity {

    private Integer id;
    private String name;
    private String description;
    private Integer idSpecie;
    private Integer idRarity;
    private String key;
}
