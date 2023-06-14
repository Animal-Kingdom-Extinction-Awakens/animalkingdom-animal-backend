package com.animalkingdom.animal.infrastructure.config.db.document;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "animal")
@Data
@Builder
public class AnimalDocument {

    @Id
    private String id;
    private String name;
    @DBRef
    private SpeciesAnimalDocument species;
    private String rarity;
    @DBRef
    private List<SkillDocument> listSkill;

}
