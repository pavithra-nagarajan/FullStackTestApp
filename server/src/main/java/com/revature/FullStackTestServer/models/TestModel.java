package com.revature.FullStackTestServer.models;

import jakarta.persistence.*;

@Entity
public class TestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    //@Column
    private String message;


    public TestModel() {

    }

    public TestModel(String message) {
        this.message = message;
    }

    public TestModel(Integer id, String message) {
        Id = id;
        this.message = message;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
