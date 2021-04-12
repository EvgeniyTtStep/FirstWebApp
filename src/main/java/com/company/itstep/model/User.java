package com.company.itstep.model;


/*ФИО, телефон, email, возраст*/

import java.util.UUID;

public class User {
    UUID id;
    String name;
    String lastName;
    String email;
    int age;
    boolean check;

    public User() {
    }

    public User(String name, String lastName, String email, int age, boolean check) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.check = check;
    }

    public User(UUID id, String name, String lastName, String email, int age, boolean check) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.check = check;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + id +'\'' +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
