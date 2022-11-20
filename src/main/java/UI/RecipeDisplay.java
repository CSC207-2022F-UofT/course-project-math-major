package UI;
//This class is the presenter that visualizes the entity.Recipe. It creates a simple UI that allow users to enter the information
//desired to create a new recipe.
import Controller.RecipeController;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class RecipeDisplay implements ActionListener{
    // This class

    private static final int rWidth = 1800;
    private static final int rLength = 1000;
    JTextField n,nameText,s,pictureText,p,i;
    JTextArea stepText;
    JButton b=new JButton("Create");

    JTable ingre;

    String data[][]={ {"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""}};
    String column[]={"Ingredients","Amount(Numbers Only)"};


    RecipeDisplay()
    {
        JFrame f=new JFrame();//creating instance of JFrame

        //creating instance of JButton
        b.setBounds(700,800,100, 40);//x axis, y axis, width, height
        //Creates the JTextFields--- which are text boxes in which the users could enter their information
        //


        //This code block creates the text field of the entity.Recipe output
        //This block of code is responsible for creating the titles and the name/steps//picture input for the users
        nameText=new JTextField("");
        n = new JTextField("Name of the Recipe");
        n.setBounds(350, 20, 160, 30);
        n.setEditable(false);
        nameText.setBounds(200,50, 400,30);
        s = new JTextField("How to Make");
        s.setBounds(380, 460, 100, 30);
        s.setEditable(false);
        stepText=new JTextArea("");
        stepText.setBounds(100,500, 1200,280);
        f.add(nameText); f.add(stepText);
        pictureText = new JTextField("");
        p = new JTextField("The file directory of the picture");
        p.setBounds(325, 150, 210, 30);
        pictureText.setBounds(200,200, 400,30);
        f.add(p);
        f.add(pictureText);
        //
        i = new JTextField("Ingredients and their quantities");
        i.setBounds(1000, 20, 190, 30);
        i.setEditable(false);
        ingre = new JTable(data, column);
        ingre.setRowHeight(35);
        ingre.setBounds(800, 50, 600, 400);
        f.add(ingre);
        f.add(i);
        f.add(b);//adding button in JFrame
        b.addActionListener(this);
        f.add(s);f.add(n);
        f.add(nameText);
        f.setSize(rWidth,rLength);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameText.getText();
        String steps = stepText.getText();



    }



    public static void main(String[] args) {
        new RecipeDisplay();
    }

}
