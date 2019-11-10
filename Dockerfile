FROM openjdk:8u191-jre-alpine3.8

# Workspace
WORKDIR /usr/share/agoda

# ADD .jar under target from host
# into this image
ADD target/Password-docker.jar 			Password-docker.jar
ADD target/Password-docker-tests.jar 	Password-docker-tests.jar
ADD target/libs							libs

# ADD suite files
ADD testng.xml				testng.xml

ENTRYPOINT java -cp Password-docker.jar:Password-docker-tests.jar:libs/* org.testng.TestNG testng.xml