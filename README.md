# Password Change Test


## Password requirement

1. At least 18 alphanumeric characters and list of special chars !@#$&*
2. At least 1 Upper case, 1 lower case ,least 1 numeric, 1 special character
3. No duplicate repeat characters more than 4
4. No more than 4 special characters
5. 50 % of password should not be a number


## Change password requirement

1. Old password should match with system
2. New password should be a valid password
3. password is not similar to old password < 80% match.

## Installation/Setup Details
1. Maven
2. Java
3. Eclipse
4. Docker

## Run through Java/Maven

```bash
mvn clean test
```

## Check Results

1. Console
2. Extent Report under folder 'TestReports' in project root.

## Run through Docker

```bash
docker run -v <directory on host machine>:/usr/share/agoda/TestReports manojguptaqa/passwordtest
```
E.g,
```bach
docker run -v /usr/share/manoj/:/usr/share/agoda/TestReports manojguptaqa/passwordtest
```
Check results in extent report generated under mapped volume directory '/usr/share/manoj/'

## About Project

#### src/main/java/PasswordMethods Package
###### ExtentManager.java : 
Configuring extent report

###### PasswordImpl.java: 
Contains password validation and change password methods

#### src/test/java/JsonReader Package
###### JsonDataReader.java : 
Utility class for reading data from test data JSON file.

#### src/main/java/PackagePasswordTestMethods

Contains test methods for 'Password Validation' and 'Password Change' methods

#### src/test/resources

contains 'data.json' file having test data for the test methods. Keep on adding new test cases to this file and that will be part of test case execution


## Creating docker image

Docker file is created and placed at root of project

##### build docker image from dockerfile by tagging it with -t

```bach
docker build -t manojguptaqa/passwordtest .
```

##### Push docker image to docker hub
```bach
docker push manojguptaqa/passwordtest:latest
```
