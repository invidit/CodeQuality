package de.invidit.design.structural.flyweight.factory;

import de.invidit.design.structural.flyweight.model.ImagePosition;
import de.invidit.design.structural.flyweight.model.PositionedImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Michael Weber
 * @since 21.05.2016
 */
public class PositionedImageFactory {
    public PositionedImage createPositionedImage(String pathToImage, ImagePosition position) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(pathToImage));
        } catch (IOException e) {
            System.out.println("Image not found");
        }
        return PositionedImage
                .builder()
                .image(image)
                .position(position)
                .build();
    }
}