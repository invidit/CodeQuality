package de.invidit.design.creational.prototype;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationItem that = (ConversationItem) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
