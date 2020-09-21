package com.example.demo.question;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="TBL_QUESTIONS")
public class Question {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="author")
    private String authro;

    @Column(name="message")
    private String message;

    @OneToMany(mappedBy = "question")
    private List<Reply> replies;

    public Question() {
    }

    public Question(Integer id, String authro, String message) {
        this.id = id;
        this.authro = authro;
        this.message = message;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
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

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", authro='" + authro + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
