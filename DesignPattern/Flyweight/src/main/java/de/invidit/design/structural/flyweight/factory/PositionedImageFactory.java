package de.invidit.design.structural.flyweight.factory;

import de.invidit.design.structural.flyweight.model.PositionedImage;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Michael Weber
 * @since 21.05.2016
 */
@Slf4j
public class PositionedImageFactory {
    public PositionedImage createPositionedImage(String pathToImage, int positionX, int positionY) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(pathToImage));
        } catch (IOException e) {
            log.warn("Image not found.", e);
        }
        return PositionedImage
                .builder()
                .image(image)
                .positionX(positionX)
                .positionY(positionY)
                .build();
    }
}