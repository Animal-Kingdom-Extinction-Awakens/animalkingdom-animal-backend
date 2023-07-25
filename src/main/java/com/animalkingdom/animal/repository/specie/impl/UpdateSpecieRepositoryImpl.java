package com.animalkingdom.animal.repository.specie.impl;

import com.animalkingdom.animal.entity.SpecieEntity;
import com.animalkingdom.animal.repository.helper.JdbcRepository;
import com.animalkingdom.animal.repository.specie.UpdateSpecieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:querys/specie/specie.properties")
public class UpdateSpecieRepositoryImpl extends JdbcRepository<SpecieEntity> implements UpdateSpecieRepository {

    @Value("${SPU.SPECIE.WHERE.ID}")
    private String spuSpecie;

    @Override
    public void update(SpecieEntity specie) {

        save(specie, spuSpecie);
    }
}
