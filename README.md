# clipboardhealthtest

## About Project
This project has UI automated tests written using Selenium Page Object model for Clipboard Health Organization

## How to run?
1. Clone the git repository
2. Make sure your machine has Java and Maven installed
3. Go to "com.clipboardhealth.ui.automation" in the Command prompt
4. Run with the command - mvn clean test "-Dbrowser.name=localchrome"
5. Once the build is successful, run the command "mvn allure:serve" to get the report
6. Report will be generated with images for each step
7. Code has flexibility to run on selenoid docker container 
8. I have setup the docker desktop and selenoid in my machine (but I couln't run it because it asks to change the system settings for my office laptop with windows OS)
9. I have build the docker image for the framework - [Docker Image](https://hub.docker.com/repository/docker/nivedhamanoharan/clipboardhealthtest/general)

Thank you for giving me the opportunity. Please feel free to reach me if there are any clarifications required.
