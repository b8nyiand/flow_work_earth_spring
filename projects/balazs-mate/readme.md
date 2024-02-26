# Bank system by Balázs Máté
This solution was made as Flow Academy's junior java developeor course's final project.


## Table of contents

- [Overview](#overview)
  - [General info](#general-info)
  - [Requirements](#requirements)
- [My process](#my-process)
  - [Built with](#built-with)
  - [Functions](#functions)
  - [Continued development](#continued-development)
  - [What I learned](#what-i-learned)
- [Author](#author)
- [Acknowledgments](#acknowledgments)


## Overview

### General info
According to the training schedule, the project phase lasted from 02.07.2024 to 02.17.2024, this was the
implementation period, I could deal with the project in this interval.


### Requirements - given by Flow Academy
The task is to create a banking API in Spring.
Configure the database according to the attached UML diagram and create the entities!
Tables should be generated based on the entities!
Let's fill your database with some test data at startup!
The creationDate fields should always be set at the time of saving!

The following functionalities are required:
- Be able to add, modify, delete users, and have endpoints that where we can request a given user by name, or all users at once!
- We can create a BankAccount for each user, we can modify it, and so on delete if necessary! We need to know what belongs to User based on username
to list bank accounts! Let's also be able to query bank accounts based on time!
- Have a separate controller that provided statistical data! These should be the the next ones:
	- We can retrieve the data of bank accounts whose balance is more than 3000 and a currency EUR
	- We can retrieve the data of bank accounts with a lower balance, than 3000, and the currency HUF!
	- We can list bank accounts whose currency is EUR!
	- Be able to query bank accounts based on currency so that we enter it as a parameter in the request!
	- We can query the bank accounts where the balance are higher than the given value
	

## My process

### Built with
- Backend:
	- Java
	- Spring Boot
	- intelliJ IDE
- Frontend:
	- Thymeleaf
	- Bootstrap
	- Visual Studio Code
- General:
	- Git/GitHub

### Functions

The project was genuinly to create a bank API. After finishing fulfilling the [requirements] (#requirements), I started to build up a whole web application. 
So the program can be used as an API (main funcionality) and as whole web API with frontend (extended functionality) too.

Actually there are a BankAccount entity and and BankUser entity. All th user can he multiple bankcaccounts, but an account can be owned by just one owner.

Main functions:
- CRUD operations - accounts
- CRUD operations - users
- Search:
	- searches by arbitrary nu,ber of conditions, e.g. bancaccounts's search fields are:
		- creation date after a choosen date
		- creation date before a choosen date
		- minimum balance value
		- maximum balance value
		- type of currency
- Exception and error handling


### Continued development
There are several functions that I would like to implement:
- create login (Spring Security) + differing user/admin functionalities
- placing the application to the web (online DB and site hosting)
- refinement of the data transfers' efficiency with using DTO-s
- create new entity: transactions - users can transfer money between bankaccounts
- since the base currency of the account can differ, an external API should be implemented to transfer money according to the actual exchange rates (e.g. Hungarian National Bank's Soap API)
- Expansion of defensive programming solutions, expansion of indexing 


### What I learned

During this project period:
- creating various type of JPQL queries
- exception- and error handling
- usage of Lombok 
- BootStrap
- connecting the frontend and the backend using Thymeleaf HTML templates


## Author

- Website - [Balázs Máté](https://matebolic.github.io/portfolio/)
- LinkedIn - [LinkedIn](https://www.linkedin.com/in/balmate)


## Acknowledgments

I thank all the mentors for their help and guidance during the whole course.
