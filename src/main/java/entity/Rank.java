package entity;

import java.io.Serializable;


public class Rank{
    private String name;
    private double value;

    /**
     * The Rank class represents a rated recipe of a user
     * which has a name and a score
     * This class has getter and setter method for the name and the rate
     * @param name The name of the recipe of the user
     * @param value The score of the recipe of the user
     */
    public Rank(String name, double value) {
        this.name = name;
        this.value = value;
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


