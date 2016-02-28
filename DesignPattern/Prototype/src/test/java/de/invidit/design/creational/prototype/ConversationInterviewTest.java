package de.invidit.design.creational.prototype;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Torsten Mingers
 */
public class ConversationInterviewTest {

    @Test
    public void testCloneCreatesCopyAndTitelIsEqual() {
        Conversation sut = createConversationInterview();

        ConversationInterview actual = (ConversationInterview) sut.clone();

        ConversationInterview sutInterview = (ConversationInterview)sut;
        Assertions.assertThat(actual.title).isEqualTo(sutInterview.title);
    }

    @Test
    public void testCloneCreatesCopyAndContainsSubitems() {
        Conversation sut = createConversationInterview();

        ConversationInterview actual = (ConversationInterview) sut.clone();

        ConversationInterview sutInterview = (ConversationInterview)sut;
        Assertions.assertThat(actual.conversationItems).containsAll(sutInterview.conversationItems);
    }

    @Test
    public void testCloneCreatesCopyAndIsNotTheSameObject() {
        Conversation sut = createConversationInterview();

        ConversationInterview actual = (ConversationInterview) sut.clone();

        ConversationInterview sutInterview = (ConversationInterview)sut;
        Assertions.assertThat(actual).isNotSameAs(sut);
    }

    private Conversation createConversationInterview() {
        ConversationInterview conversation = new ConversationInterview();

        conversation.title = "Title";
        conversation.conversationItems = new ArrayList<ConversationItem>();
        conversation.conversationItems.add(new ConversationItem("Item 1"));
        conversation.conversationItems.add(new ConversationItem("Item 2"));
        conversation.conversationItems.add(new ConversationItem("Item 3"));
        conversation.conversationItems.add(new ConversationItem("Item 4"));

        return conversation;
    }
}