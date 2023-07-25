package com.animalkingdom.animal.repository.rarity;

import com.animalkingdom.animal.dto.RarityDto;
import java.util.List;

public interface FindAllRarityRepository {

    List<RarityDto> findAll();

}
