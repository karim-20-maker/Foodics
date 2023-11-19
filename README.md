# FoodicsSelenium
# **About this repository**
This repository contains code sample using selenium4 with Cucumber and Maven  to achieve BDD concepts while testing amazon website 

  # **Environment :-** 


    # JAVA ===> java 17
    # selenium 4 ===> automate webdriver
    # TestNG ===>  test runner and annotations provider 
    # Maven ===> build and mangement tool with its pom.xml file 
    # Cucumber ===> to achieve BDD
    # IntelliJ ===> IDE
    
  
  
  
  # **Runner** :- 
  
     # CMD ====>  mvn clean test   from the level of project Ex (cd Downloads/ ApisFoodics)
     # or we can run TestRunner class    <cucumberOption.TestRunner>
     # we will find cucumber HTML Reporort created inside target/Reports/cucumber/html.html

  # **Target** :- 
  
     # Create a cucumber BDD solution utilising selenium4 framework to accomplish the following. 
     # a. 1. Open https://www.amazon.eg/ and login
     # b. 2. open "All" menu from the left side
     # c. 3. click on "video games" then choose "all video games"
     # d. 4. from the filter menu on the left side add filter "free shipping" & add the filter of condition " new"
     # e. 5. in the right side open the sort menu then sort by price: high to low
     # f. 6. add all products below that its cost below 15k EGP, if no product below
      15k EGP move to next page
     # g. 7. make sure that all products is already added to carts

           
           
   # **Note** :- 
     
     # in case of java version != 17 we can change the default SDK for projetcs modules to the current installed java version as following : 
          1- Open File menu 
          2- Open Project Structure 
          3- Choose from the dropdown menu the available java version 
          4- Click Apply then OK 
          After that you might need to restart the IDE


     
  




