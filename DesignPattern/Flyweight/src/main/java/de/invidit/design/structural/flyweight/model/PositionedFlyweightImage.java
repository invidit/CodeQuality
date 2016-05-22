package de.invidit.design.structural.flyweight.model;

import lombok.Builder;
import lombok.Data;

import java.awt.*;

/**
 * @author Michael Weber
 * @since 21.05.2016
 */
@Data
@Builder
public class PositionedFlyweightImage implements FlyweightImage {
    private Image image;

    @Override
    public void print(ImagePosition imagePosition) {

    }
}
