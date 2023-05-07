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

20:06 // Create User DTO class

22:43 // Create User Service Interface

public interface UserService {
    String addUser(UserDTO userDTO);
}

23:33 Add variable userService with annotation @Autowired to UserController class
    @Autowired
    private UserService userService;
24:49 Create package service.impl
25:02 Create UserService implementation

26:11 // Create userRepo interface
@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}

32:10 // Configure application.properties
spring.application.name=RegistrationLogin
server.port=8085

spring.jpa.hibernate.ddl-auto=create
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.datasource.url=jdbc:mysql://localhost:3306/evaluation_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=admin

#jpa vendor adapter configuration
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true

37:05 // Create SecurityConfig class file in config package

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

// Add annotation @EnableWebSecurity and extends WebSecurityConfigurerAdapter

39:59 // Add properties of Annotation to main class
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // for development

// ---------------------------------------------
40:13 // Create Login functionality
40:32 // Create LoginDTO
...
public class LoginDTO {
    private String email;
    private String password;
...
41:36 // Add method loginUser() to UserController
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
42.49 // Crete method loginUser() in UserService interface
43.19 // Create LoginResponse class in the package payload.response.
...
public class LoginResponse {
    String message;
    Boolean status;
    ....

46:14 // Create loginUser method in UserImpl
---------------------
51:12 // Create front end








