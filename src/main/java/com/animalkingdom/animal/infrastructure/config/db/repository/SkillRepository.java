package com.animalkingdom.animal.infrastructure.config.db.repository;

import com.animalkingdom.animal.infrastructure.config.db.document.SkillDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends MongoRepository<SkillDocument, String> {
}
