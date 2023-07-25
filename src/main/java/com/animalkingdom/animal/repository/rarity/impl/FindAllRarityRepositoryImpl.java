package com.animalkingdom.animal.repository.rarity.impl;

import com.animalkingdom.animal.dto.RarityDto;
import com.animalkingdom.animal.entity.RarityEntity;
import com.animalkingdom.animal.repository.helper.JdbcRepository;
import com.animalkingdom.animal.repository.rarity.FindAllRarityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:querys/rarity/rarity.properties")
public class FindAllRarityRepositoryImpl extends JdbcRepository<RarityEntity> implements FindAllRarityRepository {

    @Value("${SPS.RARITY}")
    private String spsRarity;

    @Override
    public List<RarityDto> findAll() {

        return query(spsRarity, null, BeanPropertyRowMapper.newInstance(RarityDto.class));
    }
}
