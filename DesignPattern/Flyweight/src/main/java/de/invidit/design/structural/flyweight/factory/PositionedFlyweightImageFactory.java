package de.invidit.design.structural.flyweight.factory;

import de.invidit.design.structural.flyweight.model.PositionedFlyweightImage;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Weber
 * @since 21.05.2016
 */
@Slf4j
public class PositionedFlyweightImageFactory {
    private Map<String, PositionedFlyweightImage> stringImageMap = new HashMap<>();

    public PositionedFlyweightImage createPositionedFlyweightImage(String pathToImage) {
        PositionedFlyweightImage flyweightImage = this.stringImageMap.get(pathToImage);

        if (flyweightImage == null) {
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(pathToImage));
            } catch (IOException e) {
                log.warn("Image not found.", e);
            }
            flyweightImage = PositionedFlyweightImage
                    .builder()
                    .image(bufferedImage)
                    .build();
            this.stringImageMap.put(pathToImage, flyweightImage);
        }
        return flyweightImage;
    }
}