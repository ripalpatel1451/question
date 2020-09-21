package com.example.demo.question;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="TBL_REPLIES")
public class Reply {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="author")
    private String authro;

    @Column(name="message")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Question question;

    public Reply() {
    }

    public Reply(Integer id, String authro, String message) {
        this.id = id;
        this.authro = authro;
        this.message = message;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthro() {
        return authro;
    }

    public void setAuthro(String authro) {
        this.authro = authro;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", authro='" + authro + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
