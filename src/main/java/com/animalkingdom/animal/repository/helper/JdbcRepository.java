package com.animalkingdom.animal.repository.helper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JdbcRepository<T> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(T entity, String path) {

        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(entity);
        namedParameterJdbcTemplate.update(getQuery(path), parameterSource);
    }

    protected <D> void delete(D id, String path) {

        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        namedParameterJdbcTemplate.update(getQuery(path), params);
    }

    protected <T> List<T> query(String path, MapSqlParameterSource params, RowMapper<T> rowMapper) {

        return namedParameterJdbcTemplate.query(getQuery(path), params, rowMapper);
    }

    protected <T> T queryForObject(String path, MapSqlParameterSource params, RowMapper<T> rowMapper) {

        return namedParameterJdbcTemplate.queryForObject(getQuery(path), params, rowMapper);
    }

    protected <T> T queryForObject(String path, MapSqlParameterSource params, Class<T> c) {

        return namedParameterJdbcTemplate.queryForObject(getQuery(path), params, c);
    }

    @SneakyThrows
    private String getQuery(String path) {

        ClassPathResource resource = new ClassPathResource(path);
        return new String(Files.readAllBytes(Paths.get(resource.getURI())));
    }
}
