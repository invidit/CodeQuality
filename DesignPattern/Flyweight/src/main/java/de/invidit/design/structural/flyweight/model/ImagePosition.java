package de.invidit.design.structural.flyweight.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Michael Weber
 * @since 21.05.2016
 */
@Data
@Builder
public class ImagePosition {
    private int positionX;
    private int positionY;
}
