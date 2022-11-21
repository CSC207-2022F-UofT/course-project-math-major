package entity;

import java.io.Serializable;

public class Rank implements Serializable {
    private String name;
    private double value;

    Rank(String name,double rank){
        this.name = name;
        this.value = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
