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
    private String specie;
    private RarityDto rarity;

    @Setter
    public static class Query {
        private Integer id;
        private String name;
        private String specie;
        private Integer idRarity;
        private String nameRarity;

        public AnimalDto toDto() {
            return AnimalDto.builder()
                    .id(this.id)
                    .name(this.name)
                    .specie(this.specie)
                    .rarity(RarityDto.builder()
                            .id(this.idRarity)
                            .name(this.nameRarity)
                            .build())
                    .build();
        }
    }
}
