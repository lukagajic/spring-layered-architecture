package com.lukagajic.demoapp.domain;

public class Student {
    private Integer id;
    private String forename;
    private String surname;
    private String email;

    public Student() {
        
    }

    public Student(Integer id, String forename, String surname, String email) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.email = email;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getForename() {
        return this.forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
    