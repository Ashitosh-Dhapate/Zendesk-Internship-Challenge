# ZendeskTicketViewer
Author: Ashitosh Dhapate

Coding Challenge for Zendesk Internship Position 2022. 

## Prerequisites
* Java 8

##Design Thinking
This project was given with the requirements that we should create it as simple as possible and no extra features should be added. I have used CLI based approach as per the given options in required document. Since we are not allowed to add any more functionality than mentioned in the document and we need to keep it as simple as possible I choose to write simple java classes instaed of using bulky framework like SpringBoot as we need to access only one API with minimal requirements.
Then the next alternative was to use some UI framework and do everything using it without backend. But it was more easy to use simple java methods to do this task so I choose that apporach.
Please follow the instructions mentioned below to run it and you will need to provide the subdomain of the zendesk account,username and password as we were not allowed to add credentials in code.

## Getting Started
1. Clone the git repository
2. Navigate to the root directory of the repo.
3. Execute the following command from the terminal

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
