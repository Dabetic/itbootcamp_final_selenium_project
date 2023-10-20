# Final-Selenium-Project

Web automation final project at IT Bootcamp:
Demonstrating skills for software application testing with Selenium and TestNG libraries
The project primarily involves testing a web application called "My Awesome App" (URL https://vue-demo.daniel-avellaneda.com/), and includes the following technologies: 

1. Java 
2. Maven 
3. Selenium TestNG 
4. Git

Tasks:

1. Automated functional testing of web application
2. Implementation of Page Object Model(POM) for structured organization of automated tests
3. Utilization of Selenium library for web-page interaction
4. Test implementation for:
   
   a) login
   b) registration
   c) administering location
   d) language modulation

Tests are organized into 6 test scenarios and verify different functionalities:

1. Login tests - Verifying user login functionality 
2. Signup tests - Verifying user signup functionality
3. Admin Cities tests - Testing functionalities for creating, editing, and deleting cities 
4. Auth Routes tests - Testing authentication routes
5. Locale tests - Testing page content in different languages
6. Profile tests - Testing profile page form and its functionalities

This project also includes the Helpers class, which contains "help" logic in the form of specific classes and methods:

1. Retry Analyzer - Class which will automatically retry the failed test.
2. Take a screenshot - Class which will automatically generate screenshots when a test fails.
3. Java script executor - Interface that is used to execute JavaScript with Selenium.
