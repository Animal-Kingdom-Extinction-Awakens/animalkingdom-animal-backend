package com.animalkingdom.animal.infrastructure.config.db.document.mapper;

import com.animalkingdom.animal.entity.model.Skill;
import com.animalkingdom.animal.infrastructure.config.db.document.SkillDocument;
import java.util.ArrayList;
import java.util.List;

public class SkillDocumentMapper {

    private SkillDocumentMapper() {

        throw new IllegalStateException("Utility class");
    }

    public static List<SkillDocument> toDocument(List<Skill> listSkill) {

        var listSkillDocument = new ArrayList<SkillDocument>();
        listSkill.forEach(skill ->
                listSkillDocument.add(
                        SkillDocument.builder()
                                .id(skill.getId())
                                .name(skill.getName())
                                .description(skill.getDescription())
                                .build()
                )
        );
        return listSkillDocument;
    }

    public static List<Skill> toModel(List<SkillDocument> listSkillDocument) {

        var listSkill = new ArrayList<Skill>();
        listSkillDocument.forEach(skill ->
                listSkill.add(
                        Skill.builder()
                                .id(skill.getId())
                                .name(skill.getName())
                                .description(skill.getDescription())
                                .build()
                )
        );
        return listSkill;
    }
}
