package UI;
//This class is the presenter that visualizes the entity.Recipe. It creates a simple UI that allow users to enter the information
//desired to create a new recipe.
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Map;

public class RecipeDisplay implements ActionListener{
    // This class
    String name;
    String picture;
    ArrayList<Map<String, Integer>> ingredients;
    String steps;
    private static final int rWidth = 800;
    private static final int rLength = 1000;
    JTextField n,nameText,s;
    JTextArea stepText;
    JButton b=new JButton("Create");

    RecipeDisplay()
    {
        JFrame f=new JFrame();//creating instance of JFrame

        //creating instance of JButton
        b.setBounds(350,700,100, 40);//x axis, y axis, width, height
        //Creates the JTextFields--- which are text boxes in which the users could enter their information
        //


        //This code block creates the text field of the entity.Recipe output
        nameText=new JTextField("");
        n = new JTextField("Name of a entity.Recipe");
        n.setBounds(350, 20, 120, 30);
        n.setEditable(false);
        nameText.setBounds(200,50, 400,30);
        s = new JTextField("Steps");
        s.setBounds(380, 460, 50, 30);
        s.setEditable(false);
        stepText=new JTextArea("");
        stepText.setBounds(100,500, 600,150);
        f.add(nameText); f.add(stepText);

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
