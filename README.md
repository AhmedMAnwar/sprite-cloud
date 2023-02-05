# sprite-cloud
## Introduction
Repo presenting the test cases coverage of web portal of the following [UI TEST](http://www.uitestingplayground.com/), and API of the follwoing [PET STORE](https://petstore.swagger.io/).

## Configuration
- To run the test cases using any IDE
1. JAVA JDK 17 from [JAVA LINK](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
2. Any IDE.
3. Maven plugin installed through IDE.
4. TestNG plugin installed through IDE.
5. Clone the current repo using [GIT HUB LINK](https://github.com/AhmedMAnwar/sprite-cloud)
6. Run the application as TestNG.

- To run the test cases using command line
1. Clone the current repo [GIT HUB LINK](https://github.com/AhmedMAnwar/sprite-cloud)
2. Install Maven from [MAVEN LINK](https://maven.apache.org/download.cgi)
3. Add maven through environment varibales [MAVEN SETUP](https://www.tutorialspoint.com/maven/maven_environment_setup.htm)
4. Through command line, checkout to the repo directroy, write down the following commands
    ```
     maven clean test
    ```
    
## Covered Test Cases
  **- Web test cases**
   1. Home Page [Test Cases](https://github.com/AhmedMAnwar/sprite-cloud/blob/master/src/test/java/web/HomePageTests.java)
   2. Navigation Bar [Test Cases](https://github.com/AhmedMAnwar/sprite-cloud/blob/master/src/test/java/web/NavBarTests.java)
   3. Resources Pager [Test Cases](https://github.com/AhmedMAnwar/sprite-cloud/blob/master/src/test/java/web/ResourcesTests.java)

  **- Api test cases**
   1. Store API [Test Cases](https://github.com/AhmedMAnwar/sprite-cloud/blob/master/src/test/java/api/StoreTests.java)
   2. User API [Test Cases](https://github.com/AhmedMAnwar/sprite-cloud/blob/master/src/test/java/api/UserTests.java)

## Reprts
 **TestNG Emilable Report**
 - You can check the following report through this [Link](https://github.com/AhmedMAnwar/sprite-cloud/blob/master/test-output/emailable-report.html)
 
 ![image](https://user-images.githubusercontent.com/60217499/216815578-25d6846a-ace5-4a54-9b48-8f1db8d5bb39.png)
 ---------------------------------------------------------------------------------------------------------------------------------------
 ![image](https://user-images.githubusercontent.com/60217499/216815677-50f9d5c7-03e0-4f10-bb19-157af5f87aee.png)

**Calliope Report**
![image](https://user-images.githubusercontent.com/60217499/216815725-d084f493-ef84-4ba7-9196-f904e1d4fd81.png)


## CI / CD
- The project is running on Jenkins tool locally using a "Freestyle Project" type.

     
