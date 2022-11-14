package entity;

import java.util.ArrayList;

public class UserAccount {
    private String userid;
    private String password;
    private int age;
    private char gender;
    private int weight;
    private int height;
    private int BMI;
    private ArrayList[] RecipeBook;

    public UserAccount(String userid, String password, int age, char gender, int weight, int height) {
        this.userid = userid;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }


}
