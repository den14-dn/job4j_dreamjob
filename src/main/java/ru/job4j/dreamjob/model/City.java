package ru.job4j.dreamjob.model;

import java.util.Objects;

public class City {
    private int id;
    private String name;

    public City() {
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
           return false;
        }

        City city = (City) obj;
        return id == city.id;
    }
}
