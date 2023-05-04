https://youtu.be/kgTaJzI7sfM
Login Registration Form Restful Api Using Spring boot Angular
Tutus Funny (https://www.tutussfunny.com/login-registration-form-using-spring-boot-angular/)

4:13 // Create spring boot 3 project with spring initializer (https://start.spring.io/)
Project - maven
Language - Java
Spring Boot - 3.0.6
Project Metadata: 
  - Group: com.illya
  - Artifact: server
  - Name: server
  - Description: Evaluation Project
  - Package name: com.illya.server
Packaging - Jar
Java - 8
Dependencies(pom.xml):
  - Spring Data JPA
  - MySQL Driver
  - Spring Web
  - Spring Security
  - Validation
-- Generate --
9:22 // Main Java method in the class ...Application with annotation @SpringBootApplication
//
Example:
src/main/java
    +- com
        +- example
            +- Application.java
            +- ApplicationConstants.java
                +- configuration
                |   +- ApplicationConfiguration.java
                +- controller
                |   +- ApplicationController.java
                +- dao
                |   +- impl
                |   |   +- ApplicationDaoImpl.java
                |   +- ApplicationDao.java
                +- dto
                |   +- ApplicationDto.java
                +- service
                |   +- impl
                |   |   +- ApplicationServiceImpl.java
                |   +- ApplicationService.java
                +- util
                |   +- ApplicationUtils.java
                +- validation
                |   +- impl
                |   |   +- ApplicationValidationImpl.java
                |   +- ApplicationValidation.java
//
9:32
// Create new package config and Config class
// Create new package controller and Controller class
// Create new package dto and Dto class
// Create new package entity and Entity class
// Create new package repository and Repository class
// Create new package service and Service class
11:27 // Create UserController class in controller package 
12:48 // Annotation for UserController class
@RestController // REST API
@CrossOrigin  // for connect to the front end application
@RequestMapping("api/vi/user") // url of request
public class UserController {....

13:26 // Add method save() to class UserController
    @PostMapping("/save") // Annotation for mapping HTTP POST requests onto specific handler methods
    public String saveUser(@RequestBody User userDTO){
        String id =userService.addUser(userDTO);
        return id;
    }

14:17 // Create User class in entity package.




