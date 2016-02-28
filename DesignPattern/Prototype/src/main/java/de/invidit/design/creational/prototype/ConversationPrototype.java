package de.invidit.design.creational.prototype;

import java.util.List;
import java.util.Objects;

/**
 * @author Torsten Mingers
 */
public abstract class ConversationPrototype implements Conversation {
    public String title;
    public List<ConversationItem> conversationItems;

    public abstract ConversationPrototype clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConversationPrototype that = (ConversationPrototype) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(conversationItems, that.conversationItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, conversationItems);
    }
}
