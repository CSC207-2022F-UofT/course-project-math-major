package entity;

import java.io.Serial;
import java.io.Serializable;

public class Ingredient implements Serializable {
    @Serial
    private String name;

    private int quantity;

    private String unit;

    public Ingredient(String name, int quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return String.format("%d %s of %s", quantity, unit, name);
    }
}
