# RESTful service Diamonds

## What
This is a simple REST project

## Why
I wrote this project to learn and use new technologies using the Spring framework. If you are also studying it and you are interested in the technologies used in this project,you can take it as a basis and I will help you understand how everything is arranged here.

## How
Technologies used in this project:
 - Spring Boot
 - Spring Web
 - Spring Data JDBC (DAO classes)
 - PostgreSQL database
 - Lombok
 - JUnit5 (tests)
 - H2 database (tests)

# How to Install and Run the project

1. You need a database to work with. In my project i used **Postgres** database, but you can use any, just dont forget to change **spring.datasource.url** in project.
2. Install Maven on your local machine, you can watch [this video](https://www.youtube.com/watch?v=km3tLti4TCM).
3. Clone this github repository to your local machine.
4. Open the project and let Maven download all dependencies.
5. After first application startup you should see new table **diamonds** in your database.

# How to Use the project

Now, when the application is running, you can send different url requests to operate with with your database.

Screen![Collection](https://imgur.com/a/Z0hWGRk).
Data was taken from "https://www.kaggle.com/datasets/joebeachcapital/diamonds/data".
