package com.animalkingdom.animal.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RarityEnum {

    COMMON(1),
    RARE(2),
    EPIC(3),
    LEGENDARY(4);

    private final int id;
}
