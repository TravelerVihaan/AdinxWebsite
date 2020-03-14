# TripWebsite
Web service designed for my friend's company

## Used technology stack
Spring Boot 2<br>
Java 13<br>
MySQL<br>
Junit5 in tests<br>
REST<br>

## Packaging
Fat Jar by Maven

### Only backend side

Service allows users to make reservations for trips, fill form with information about number of people in group, and shows informations about price.

### REST API<br>
Below I presemted REST endpoints 
Fpr Users:
* Users
GET ```/users```<br> : Main endpoint for Users entitiies operation, Returns reposne with collection of objects loaded from database<br>
GET  ```/users/{username}```<br> Endpoint for user page adninistration - get UserDTO by username, which is unique<br>
POST ```/users```<br> Cpmsume jsom with TripDTO informations, and transfer ot tp Tro[. amd mext save om database. of tke sa,e iserma,e is not exists alreadu om data spirce<br>

* Trips


