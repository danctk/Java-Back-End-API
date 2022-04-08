package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;



@CrossOrigin
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String due;

    private boolean done;

    public Task() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
//HttpHeaders responseHeaders = new HttpHeaders();
//    responseHeaders.add("Access-Control-Allow-Methods", "POST, GET"); // also added header to allow POST, GET method to be available
//responseHeaders.add("Access-Control-Allow-Origin", "*"); // also added header to allow cross domain request for any domain

}
