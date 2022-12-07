package entity;

/**
 * The Rank class represents a rated recipe of a user
 * which has a recipe name and a score for the recipe
 * This class has getter and setter method for the name and the rate
 */
public class Rank{
    private String name;
    private double value;

    /**
     * This method generates an instance of the scored recipe
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


