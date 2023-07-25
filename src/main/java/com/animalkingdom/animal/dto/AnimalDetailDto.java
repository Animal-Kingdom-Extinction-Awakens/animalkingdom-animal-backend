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
public class AnimalDetailDto {

    private Integer id;
    private String name;
    private String description;
    private SpecieDto specie;
    private RarityDto rarity;

    @Setter
    public static class Query {
        private Integer id;
        private String name;
        private String description;
        private Integer idSpecie;
        private String nameSpecie;
        private String descriptionSpecie;
        private Integer idRarity;
        private String nameRarity;

        public AnimalDetailDto toDto() {
            return AnimalDetailDto.builder()
                    .id(this.id)
                    .name(this.name)
                    .description(this.description)
                    .specie(SpecieDto.builder()
                            .id(this.idSpecie)
                            .name(this.nameSpecie)
                            .description(this.descriptionSpecie)
                            .build())
                    .rarity(RarityDto.builder()
                            .id(this.idRarity)
                            .name(this.nameRarity)
                            .build())
                    .build();
        }
    }

}
