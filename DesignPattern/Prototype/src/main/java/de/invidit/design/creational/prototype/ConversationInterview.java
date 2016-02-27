/*
 * Copyright (c) 2016. InvidIT.de
 */

package de.invidit.design.creational.prototype;

import java.util.stream.Collectors;

/**
 * @author Torsten Mingers
 * @since 27.02.2016
 */
public class ConversationInterview extends ConversationPrototype {

    @Override
    public Conversation clone() {
        ConversationInterview conversation = new ConversationInterview();
        conversation.title = this.title;
        conversation.conversationItems = this.conversationItems
                .stream()
                .map(item -> new ConversationItem(item))
                .collect(Collectors.toList());

        return conversation;
    }
}