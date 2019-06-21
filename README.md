# Example of API Automation testing project

Please make sure you have following elements installed to be able to run the solution:

Java 1.8;
Maven;
Eclipse IDE (once you install eclipse IDE please go to Help/Marketplace and install TestNG plugin);

Following project is a basic example of API testing using REST Assured, Java, Maven and TestNG.
Using AWS API Gateway I created simple API of pet store.

There are 2 tests in the project;

*Test 1* - makes a GET call to basic API and asserts default view and content (3 animals with id,tytle and price)	

*Test 2* - creates A POST call to add new animal to the Pet store API and asserts success of the operation (200 status code) 
          and content of the output.

If you ever have issues with imports or other errors in the code please try to clean the project, to do that got to Project menu -> Clean and select necessary project.
          
This project is created using only open source tools by Oleksii Liulka.

Have a good day.
