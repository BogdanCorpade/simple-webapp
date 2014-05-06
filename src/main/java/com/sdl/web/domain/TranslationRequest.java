package com.sdl.web.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TranslationRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String text;
    private String from;
    private String to;

    public TranslationRequest(String text, String from, String to) {
        this.text = text;
        this.from = from;
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
