package com.animalkingdom.animal.repository.specie;

import com.animalkingdom.animal.dto.SpecieDto;
import java.util.List;

public interface FindAllSpecieRepository {

    List<SpecieDto> findAll();

}
