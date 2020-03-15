# TripWebsite
Web service designed for my friend's company

## Used technology stack
Spring Boot 2<br>
Java 13<br>
MySQL<br>
Junit 5 in tests<br>
REST<br>

## Packaging
``Fat Jar``` by Maven

### Only backend side

Service allows users to make reservations for trips, fill form with information about number of people in group, and shows informations about price.

### REST API<br>
Below I present REST endpoints 
Fpr Users:
* Users
GET ```/users```<br> : Main endpoint for Users entities operation, Returns response with collection of objects loaded from database<br>
GET  ```/users/{username}```<br> Endpoint for user page administration - get UserDTO by username, which is unique<br>
POST ```/users```<br> Consume json with UserDTO information, and transfer it to User Entity. If trip already exists om database. them saving object to DB will not ne performed.

* Trips
GET ```/trips```<br> : Main endpoint for Trips entities operation, Returns response with collection of objects loaded from database<br>
GET  ```/trips/{username}```<br> Endpoint for trip page administration - get TripDTO by voucher number, which is unique<br>
POST ```/trips```<br> Consume json with TripDTO information, and transfer it to Trip, amd next save to database, if the same trip entity is not exists already om data source<br>



