package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class UserAccount implements Serializable {
    private final String userid;
    private String password;
    private int age;
    private char gender;
    private float weight;
    private float height;
    private ArrayList<Recipe> RecipeBook;

    public UserAccount(String userid, String password, int age, char gender, float weight, float height) {
        this.userid = userid;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
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
