package de.invidit.design.structural.decorator;

/**
 * @author Michael Weber
 * @since 29.03.2016
 */
public class Main {
    public static void main(String...args) {

        System.out.println("Original dishwasher:");
        Dishwasher dishwasher = new NoNameSimpleDishwasher();
        dishwasher.wash();

        System.out.println("Decorated dishwasher:");
        dishwasher = new DishwasherLoggingDecorator(new NoNameSimpleDishwasher());
        dishwasher.wash();
    }
}
