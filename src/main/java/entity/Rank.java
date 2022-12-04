package entity;

import java.io.Serializable;

// Here we use a design pattern Serializable, so Rank can iterate
public class Rank implements Serializable {
    private String name;
    private double value;

    public Rank(String name, double rank) {
        this.name = name;
        this.value = rank;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }
}


