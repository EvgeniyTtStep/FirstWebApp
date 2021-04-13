package com.company.itstep.model;

import java.util.UUID;

public class Developer {
    UUID id;
    String name;
    String skill;

    public Developer() {
    }

    public Developer(UUID id, String name, String skill) {
        this.id = id;
        this.name = name;
        this.skill = skill;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
