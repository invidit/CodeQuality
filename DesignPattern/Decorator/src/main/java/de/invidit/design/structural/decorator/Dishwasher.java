package de.invidit.design.structural.decorator;

import de.invidit.design.structural.decorator.model.Dishes;

import java.util.List;

/**
 * @author Michael Weber
 * @since 29.03.2016
 */
public interface Dishwasher {
    void load(List<Dishes> dishes);
    void wash();
    List<Dishes> clearOut();
}
