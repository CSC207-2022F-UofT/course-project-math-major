package entity;

import java.util.ArrayList;

public class UserAccount {
    private final String userid;
    private String password;
    private int age;
    private final char gender;
    private int weight;
    private int height;
    private int BMI;
    private ArrayList<Recipe> RecipeBook;

    public UserAccount(String userid, String password, int age, char gender, int weight, int height) {
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

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getBMI() {
        return BMI;
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

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBMI(int BMI) {
        this.BMI = BMI;
    }

    public void setRecipeBook(ArrayList<Recipe> recipeBook) {
        RecipeBook = recipeBook;
    }



}
