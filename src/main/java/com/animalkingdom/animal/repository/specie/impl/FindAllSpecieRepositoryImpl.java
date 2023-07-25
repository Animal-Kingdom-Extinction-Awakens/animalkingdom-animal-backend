package com.animalkingdom.animal.repository.specie.impl;

import com.animalkingdom.animal.dto.SpecieDto;
import com.animalkingdom.animal.entity.AnimalEntity;
import com.animalkingdom.animal.repository.helper.JdbcRepository;
import com.animalkingdom.animal.repository.specie.FindAllSpecieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:querys/specie/specie.properties")
public class FindAllSpecieRepositoryImpl extends JdbcRepository<AnimalEntity> implements FindAllSpecieRepository {

    @Value("${SPS.SPECIE}")
    private String spsSpecie;

    @Override
    public List<SpecieDto> findAll() {

        return query(spsSpecie, null, BeanPropertyRowMapper.newInstance(SpecieDto.class));
    }
}
