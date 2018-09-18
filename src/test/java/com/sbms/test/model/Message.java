package com.sbms.test.model;

import org.bson.Document;

public class Message {
    private final String language;

    private final String content;

    public Message(String language, String content) {
        this.language = language;
        this.content = content;
    }

    public String getLanguage() {
        return language;
    }

    public String getContent() {
        return content;
    }

    public Document toDocument() {
        return new Document().append("language", language).append("content", content);
    }
}
