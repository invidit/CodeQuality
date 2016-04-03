package de.invidit.design.structural.decorator;

import de.invidit.design.structural.decorator.model.Dishes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Weber
 * @since 29.03.2016
 */
public class DishwasherLoggingDecorator implements Dishwasher {
    private Dishwasher decoratedDishwasher;

    public DishwasherLoggingDecorator(Dishwasher dishwasher) {
        this.decoratedDishwasher = dishwasher;
    }

    @Override
    public void load(List<Dishes> dishes) {
        this.decoratedDishwasher.load(dishes);
        System.out.println("Dishes loaded");
    }

    @Override
    public void wash() {
        this.decoratedDishwasher.wash();
        System.out.println("Dishes washed");
    }

    @Override
    public List<Dishes> clearOut() {
        System.out.println("Clear out sparkling dishes");
        return this.decoratedDishwasher.clearOut();
    }
}
