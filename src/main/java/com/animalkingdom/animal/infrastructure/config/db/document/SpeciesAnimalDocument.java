package com.animalkingdom.animal.infrastructure.config.db.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "species")
@Data
@Builder
public class SpeciesAnimalDocument {

    @Id
    private String id;
    private String name;
    private String description;
}
