package de.invidit.design.structural.decorator;

import de.invidit.design.structural.decorator.model.Dishes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Weber
 * @since 29.03.2016
 */
public class NoNameSimpleDishwasher implements Dishwasher {
    private List<Dishes> loadedDishes;

    public NoNameSimpleDishwasher() {
        this.loadedDishes = new ArrayList<>();
    }

    @Override
    public void load(List<Dishes> dishes) {
        this.loadedDishes = dishes;
    }

    @Override
    public void wash() {
        // make everything pretty clean
    }

    @Override
    public List<Dishes> clearOut() {
        return this.loadedDishes;
    }
}
