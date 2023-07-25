package com.animalkingdom.animal.usecase.helper;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AwsBucketHelper {

    @Autowired
    private AmazonS3 amazonS3Client;

    @Value("${aws.bucketName}")
    private String bucketName;

    public String uploadContentToBucket(File file, String fileName) throws RuntimeException {

        try {

            if (amazonS3Client.doesBucketExistV2(bucketName)) {
                PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file);
                amazonS3Client.putObject(putObjectRequest);

                return amazonS3Client.getObject(bucketName, fileName).getKey();
            }

            throw new RuntimeException("Bucket not exist!");
        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        } finally {
            file.delete();
        }
    }

    public String getUrl(String key) {
        return amazonS3Client.getUrl(bucketName, key).toString();
    }

    public S3Object getObject(String image) {
        return amazonS3Client.getObject(bucketName, image);
    }

    public void deleteObject(String key) {

        amazonS3Client.deleteObject(bucketName, key);
    }
}
