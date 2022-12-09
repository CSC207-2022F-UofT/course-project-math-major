package entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/** This class represents the account of users. It contains values such as Strings userid, password, Integer age,
 * Char gender, and float weight and height. **/

public class UserAccount implements Serializable {
    @Serial
    private static final long serialVersionUID = -3801018242841964674L;
    private final String userid;
    private String password;
    private int age;
    private char gender;
    private float weight;
    private float height;
    private ArrayList<Recipe> RecipeBook;

    public UserAccount(String userid, String password) {
        this.userid = userid;
        this.password = password;
        this.age = 0;
        this.gender = 'M';
        this.weight = 0.0f;
        this.height = 0.0f;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public ArrayList<Recipe> getRecipeBook() {
        return RecipeBook;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {this.gender = gender;}

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setRecipeBook(ArrayList<Recipe> recipeBook) {
        RecipeBook = recipeBook;
    }

}
