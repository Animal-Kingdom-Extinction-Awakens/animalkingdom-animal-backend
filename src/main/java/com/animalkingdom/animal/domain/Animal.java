package com.animalkingdom.animal.domain;

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
public class Animal {

    private Integer id;
    private String name;
    private String description;
    private Specie specie;
    private Rarity rarity;
    private String key;
}
