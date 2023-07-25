package com.animalkingdom.animal.usecase.helper;

import com.animalkingdom.animal.exception.BusinessException;
import com.animalkingdom.animal.exception.ServerException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

public class ImageHelper {

    private final MultipartFile multipartFile;
    private final Path basePath = Paths.get(System.getProperty("java.io.tmpdir"));

    public ImageHelper(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public File convertMultipartFileToFile() {

        File file = new File(basePath.toFile(), Objects.requireNonNull(this.multipartFile.getOriginalFilename()));

        try {

            this.multipartFile.transferTo(file);
            validateImage(file);

        } catch (BusinessException e) {

            throw e;
        } catch (Exception e) {

            throw new ServerException(e.getMessage());
        }
        return file;
    }

    private void validateImage(File file) throws IOException {

        try {

            Assert.isTrue(file.exists(), "A imagem anexada não é válida.");

            String regex = "([^\\s]+(\\.(?i)(png))$)";
            Pattern p = Pattern.compile(regex);
            Matcher matcher = p.matcher(file.getName());
            Assert.isTrue(matcher.matches(), "A imagem deve ser do tipo PNG.");

            BufferedImage image = ImageIO.read(file);

            Assert.notNull(image, "A imagem anexada não é válida.");

            int width = image.getWidth();
            int height = image.getHeight();
            Assert.isTrue(width == 512 && height == 512, "A imagem deve ter a resolução de 512x512 pixels.");
            Assert.isTrue(image.getType() != BufferedImage.TYPE_INT_RGB, "A imagem deve ser do tipo RGB.");

        } catch (IllegalArgumentException e) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public static String buildFileName() {
        return String.format("animal/image/%s-%s/r512.png", UUID.randomUUID(), System.currentTimeMillis());
    }
}
