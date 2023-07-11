package com.animalkingdom.animal.repository.animal.impl;

import com.animalkingdom.animal.dto.AnimalDto;
import com.animalkingdom.animal.entity.AnimalEntity;
import com.animalkingdom.animal.repository.animal.FindAllAnimalRepository;
import com.animalkingdom.animal.repository.helper.JdbcRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:querys/animal/animal.properties")
public class FindAllAnimalRepositoryImpl extends JdbcRepository<AnimalEntity> implements FindAllAnimalRepository {

    @Value("${SPS.ANIMAL}")
    private String spsAnimal;

    @Override
    public List<AnimalDto> findAll() {

        return query(spsAnimal, null, BeanPropertyRowMapper.newInstance(AnimalDto.class));
    }
}
