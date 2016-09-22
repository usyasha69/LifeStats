package com.example.pk.lifestats;

import java.io.Serializable;

public class LifeStatsModel implements Serializable {
    private String name;
    private String date;

    public LifeStatsModel(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LifeStatsModel{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
