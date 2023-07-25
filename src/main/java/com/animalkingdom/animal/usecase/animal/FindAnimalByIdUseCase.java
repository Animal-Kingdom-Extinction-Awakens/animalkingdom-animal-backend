package com.animalkingdom.animal.usecase.animal;

import com.animalkingdom.animal.dto.AnimalDetailDto;
import com.animalkingdom.animal.exception.BusinessException;
import com.animalkingdom.animal.exception.ServerException;
import com.animalkingdom.animal.repository.animal.FindAnimalByIdRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindAnimalByIdUseCase {

    final FindAnimalByIdRepository repository;

    public AnimalDetailDto execute(Integer id) {

        try {

            return this.repository.findById(id);
        } catch (EmptyResultDataAccessException e) {

            throw new BusinessException(HttpStatus.NOT_FOUND, "Animal not found");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new ServerException(e.getMessage());
        }
    }
}
