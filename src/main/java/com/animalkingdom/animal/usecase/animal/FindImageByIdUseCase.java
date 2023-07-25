package com.animalkingdom.animal.usecase.animal;

import com.amazonaws.services.s3.model.S3Object;
import com.animalkingdom.animal.exception.BusinessException;
import com.animalkingdom.animal.exception.ServerException;
import com.animalkingdom.animal.repository.animal.FindImageByIdRespository;
import com.animalkingdom.animal.usecase.helper.AwsBucketHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindImageByIdUseCase {

    final FindImageByIdRespository repository;
    final AwsBucketHelper awsBucketHelper;

    public byte[] execute(Integer id) {

        try {

            String key = this.repository.findImageById(id);
            Assert.notNull(key, "Image not found");

            S3Object object = awsBucketHelper.getObject(key);
            return object.getObjectContent().readAllBytes();
        } catch (IllegalArgumentException e) {

            throw new BusinessException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServerException(e.getMessage());
        }
    }
}
