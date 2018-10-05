# resp_java
Author: Alex Mueller  
Date: October 2018

This is a Java solution to a problem for Matching Respondents With Projects (Paid Opportunities) by Location.  
  
We have some respondents in a text file (respondents.csv attached) one respondent per line that we would like to match 
with a project (project.json attached). We want to invite all respondents that fit in the cities of the project within 
a 100km radius.  
  
This program will read the full list of respondents and output the names and distance of
matching respondents (within 100km), sorted by name (ascending).  


### Prerequisites and Dependencies
You need to have Java installed on your computer. This project was built with Java 8. 
If you don't already have Java installed, go to Java's website 
at https://www.java.com/en/download/ and click the Free Java Download button below the latest version of Java, 
then install Java once it downloads. You may have to restart your computer for Java to be fully implemented.
  
To run a Jar file, read more here, https://www.wikihow.com/Run-a-.Jar-Java-File.  
  
If you want to build, compile, test, and package via Maven, you will need to install Maven, 
https://maven.apache.org/install.html. 


### Instructions to run the project
Once Java is installed, download the jar file to a directory and run the following commands in a terminal/console.  
  
There are two required command line arguments and two optional arguments.  
  
Required Arguments:  
* projectJson=/path/to/the/project.json.file
* respondentsCsv=/path/to/the/respondents.csv.file
  
Optional Arguments:  
* distance=100 [integer value 0 to 40075, as 40075 is the maximum number of kilometers around earth]
* isMiles=true [true or false, true if the desire output should be in miles, otherwise false will be in kilometers]  
  
Example Command Line Arguments:  
java -cp "respondent-jar-with-dependencies.jar" com.respondent.Main 
--projectJson=project.json 
--respondentsCsv=respondents.csv 
  
Alternate commands to run:  
java -cp "respondent-jar-with-dependencies.jar" com.respondent.Main 
--projectJson=project.json 
--respondentsCsv=respondents.csv 
--distance=50 
  
Alternate commands to run:  
java -cp "respondent-jar-with-dependencies.jar" com.respondent.Main 
--projectJson=project.json 
--respondentsCsv=respondents.csv 
--distance=75
--isMiles=true

### Building
mvn clean compile package
<br/>

### Running the tests

The tests can be run via Maven by running "mvn test" from the root of the project on the command line. 
