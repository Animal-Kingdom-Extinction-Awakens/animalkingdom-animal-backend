package com.animalkingdom.animal.repository.animal.impl;

import com.animalkingdom.animal.dto.AnimalDetailDto;
import com.animalkingdom.animal.entity.AnimalEntity;
import com.animalkingdom.animal.repository.animal.FindAnimalByIdRepository;
import com.animalkingdom.animal.repository.helper.JdbcRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:querys/animal/animal.properties")
public class FindAnimalByIdRepositoryImpl extends JdbcRepository<AnimalEntity> implements FindAnimalByIdRepository {

    @Value("${SPS.ANIMAL.WHERE.ID}")
    private String spsAnimalWhereId;

    @Override
    public AnimalDetailDto findById(Integer id) {

        AnimalDetailDto.Query animalQuery = queryForObject(spsAnimalWhereId, new MapSqlParameterSource("id", id), BeanPropertyRowMapper.newInstance(AnimalDetailDto.Query.class));
        return animalQuery.toDto();
    }
}
