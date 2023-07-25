package com.animalkingdom.animal.repository.animal.impl;

import com.animalkingdom.animal.dto.AnimalDto;
import com.animalkingdom.animal.entity.AnimalEntity;
import com.animalkingdom.animal.repository.animal.FindImageByIdRespository;
import com.animalkingdom.animal.repository.helper.JdbcRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:querys/animal/animal.properties")
public class FindImageByIdRespositoryImpl extends JdbcRepository<AnimalEntity> implements FindImageByIdRespository {

    @Value("${SPS.IMAGE.WHERE.ID}")
    private String spsImageWhereId;

    @Override
    public String findImageById(Integer id) {
        return queryForObject(spsImageWhereId, new MapSqlParameterSource("id", id), String.class);
    }
}
