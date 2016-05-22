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
public class PositionedImage {
    private Image image;
    private int positionX;
    private int positionY;

    public void print() {
        // print image on specified position
    }
}
