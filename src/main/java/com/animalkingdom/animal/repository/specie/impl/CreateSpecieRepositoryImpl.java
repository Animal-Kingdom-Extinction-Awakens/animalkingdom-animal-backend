package com.animalkingdom.animal.repository.specie.impl;

import com.animalkingdom.animal.entity.SpecieEntity;
import com.animalkingdom.animal.repository.helper.JdbcRepository;
import com.animalkingdom.animal.repository.specie.CreateSpecieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:querys/specie/specie.properties")
public class CreateSpecieRepositoryImpl extends JdbcRepository<SpecieEntity> implements CreateSpecieRepository {

    @Value("${SPI.SPECIE}")
    private String spiSpecie;

    @Override
    public void create(SpecieEntity specie) {

        save(specie, spiSpecie);
    }
}
