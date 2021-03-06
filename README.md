# ZendeskTicketViewer
Author: Ashitosh Dhapate

Coding Challenge for Zendesk Internship Position 2022.

Respected Sir/Madam, Thank you for extending this opportunity. Please find details about my task below.

## Prerequisites
* Java 8

## Design Thinking  
This project was given with the requirements that we should create it as simple as possible and no extra features should be added. I have used CLI based approach as per the given options in required document. Since we are not allowed to add any more functionality than mentioned in the document and we need to keep it as simple as possible I choose to write simple java classes instaed of using bulky framework like SpringBoot as we need to access only one API with minimal requirements.
Then the next alternative was to use some UI framework and do everything using it without backend. But it was more easy to use simple java methods to do this task so I choose that apporach.  
Please follow the instructions mentioned below to run it and you will need to provide the subdomain of the zendesk account,username and password as we were not allowed to add credentials in code.  


## Getting Started
1. Clone the git repository
2. Navigate to the root directory of the repo.
3. Execute the following command from the terminal.  

Most of the times only importing this project in an IDE like intellij will do automatic build and you can directly run the application. 

Windows:

```
gradlew installDist
```

OSX/Linux:

```
chmod +x gradlew
./gradlew installDist
```

4. Run the following:

Windows:

```
build\install\ZendeskTicketViewer\bin\ZendeskTicketViewer.bat
```

OSX/Linux:

```
./build/install/ZendeskTicketViewer/bin/ZendeskTicketViewer
```

5. Giving Input
```
You will need to provide the subdomain of the zendesk account,username and password as we were not allowed to add credentials in code.

```

## Running Tests
Since out of 5 functionality classed 2 of them were for handling input and displaying the promts so I have not added the basic test cases for them. For the rest of the 3 major classes I have added important logical as well as basic testcases as well.
To verify the tests run correctly, go to the working directory and run the following command:

Windows:

```
gradlew test
```

OSX/Linux:

```
./gradlew test
```

## More information on classes created

TicketsApp - The main class to start the application.  
TicketsViewer - This class is part of the view which is responsible for showing all the data on CLI.  
InputProcessor - InputProcessor is the small part controller of the program, which handles all the user input.  
TicketsClient - This is a service level class which connects with zendesk API and fetches all data by performing authentication.  
TicketsDTO - This is a part of model(a DAO level class) which is a POJO to store info of all the tickets.  
TicketsProcessor - This is a part of controller having business logic to implement pagination and show tickets based on option chosen by user.
