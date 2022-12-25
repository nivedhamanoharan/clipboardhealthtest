FROM maven:3.8.6-eclipse-temurin-17 as base

WORKDIR /com.clipboardhealth.ui.automation

COPY src /home/ClipboardHealthTest/src

COPY pom.xml /home/ClipboardHealthTest

COPY testng.xml /home/ClipboardHealthTest

FROM base as build
RUN mvn -f /home/ClipboardHealthTest/pom.xml clean install "-Dbrowser.name=chrome"
RUN mvn -f /home/ClipboardHealthTest/pom.xml allure:serve