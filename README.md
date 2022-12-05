# Recipe Application Project
## Group 18- Math Major
This is the RecipeBook project made by group 18-Math-Majors
This project includes functions such as

Registering/Login into accounts

Viewing/Creating Recipe books

Calculating the food's basic 
calories based on the ingredients
Giving feedback based on the healthiness of the Recipe and ranking them based on it


## Project Requirements
- SDK: Amazon Correto version 18.0.2
- Language Level: above 14

## How to use the Recipe Application!
**1. Running the Program and Login
Find ProjectMain in `java/ui/ProjectMain.java`, This should be the only part runnable in the whole project. Run this class and it will prompt you to a login page.

<img width="264" alt="Screenshot 2022-12-03 at 11 57 43 PM" src="https://user-images.githubusercontent.com/93350299/205475447-30641c19-1469-474f-9b50-6c66854c2e8f.png">

If you don't have a registered account, you would click on register to register for a brand new account with a username and password. 
<img width="337" alt="Screenshot 2022-12-03 at 11 58 55 PM" src="https://user-images.githubusercontent.com/93350299/205475743-f31ff2f1-b609-46eb-a75b-58ad631f11cc.png">

If you do have an account, simply type in the correct username and password to login.

**2. UserInfo section

Once logged in, the user now enters a brand new UI page called the **User Information Page**

<img width="797" alt="Screenshot 2022-12-03 at 11 59 50 PM" src="https://user-images.githubusercontent.com/93350299/205475768-aecffaac-af70-4319-80b5-1685b8c0d8a9.png">

In this section, the user would update their personal information such as their age, weight, gender... All the changes the user made would be sent to the gateway and saved for future uses. And If the user wants to checkout their recipe book, they would click on the **Edit Recipe** button

**3. Recipe Book**
<img width="1196" alt="Screenshot 2022-12-04 at 12 03 01 AM" src="https://user-images.githubusercontent.com/93350299/205475865-b12ab5a3-5836-4fa6-84d2-b83bb2da7813.png">
The Recipe Book shows you all the Recipe that you had created in the past, if this is your first time using it the recipe book would be empty with nothing. In this case you want to click on the Create Recipe button at the top of the UI and add your brand new Recipe.

**4. Recipe Creation**

Once you had clicked on the Create Recipe button, you will be sent to the Recipe Creation/Deletion UI.

<img width="1098" alt="Screenshot 2022-12-04 at 7 44 20 PM" src="https://user-images.githubusercontent.com/93350299/205526496-48a0f6f8-ec5b-4540-8ceb-2863a5386df7.png">

On this page you could enter a Recipe Name, and their ingredients as well as the steps making it. The application will then calculate the calories for your recipe and create it in the Recipe Book. Once you had entered the desired information, click on 


**5 Recipe Deletion**
If you want to delete a Recipe, go to the Delete Recipe button on the left bottom of the RecipeCreation UI. Once clicked, it prompt you to another UI. You could enter the name of the Recipe you want to delete and it will delete for you.

<img width="697" alt="Screenshot 2022-12-04 at 7 47 25 PM" src="https://user-images.githubusercontent.com/93350299/205526651-60b7e79d-704a-480f-b4df-aa9600ad3b98.png">


**6. Rating and Ranking**

After creating your recipes, you could go back to the User Information Page and check out the ranking function by clicking on Show Rank
<img width="994" alt="Screenshot 2022-12-04 at 12 03 49 AM" src="https://user-images.githubusercontent.com/93350299/205476025-7219052c-fc4d-4492-930c-e30760797710.png">
This button will prompt you to the **Personal Ranking** section, the system will then rate your Recipes and return them back to you in order of Ranking. 

**Closing**

After you are done with your Recipe Application, you could close it, and once you comeback all the information would still be there, like an actural Recipe Book that provides you with feedback!
