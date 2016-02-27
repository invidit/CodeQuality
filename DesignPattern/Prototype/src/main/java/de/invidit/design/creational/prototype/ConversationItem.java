package de.invidit.design.creational.prototype;

/**
 * @author Torsten Mingers
 */
public class ConversationItem {

    public String name;

    // Imagine a very complicated class that can only be created with lots of effort...

    public ConversationItem(String name) {
        this.name = name;
    }

    // Copy Constructor
    public ConversationItem(ConversationItem item) {
        this.name = item.name;
        // more copy code goes here
    }
}
