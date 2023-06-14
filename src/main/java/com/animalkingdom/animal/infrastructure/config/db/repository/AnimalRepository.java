package com.animalkingdom.animal.infrastructure.config.db.repository;

import com.animalkingdom.animal.infrastructure.config.db.document.AnimalDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends MongoRepository<AnimalDocument, String> {
}
