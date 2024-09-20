package org.blog.springboot.domain.entities;

import org.blog.springboot.domain.dto.UserSummary;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class Comment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String text;
    private Instant moment;
    private UserSummary author;

    public Comment() {}

    public Comment(String text, Instant moment, UserSummary author) {
        this.text = text;
        this.moment = moment;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public UserSummary getAuthor() {
        return author;
    }

    public void setAuthor(UserSummary author) {
        this.author = author;
    }
}
