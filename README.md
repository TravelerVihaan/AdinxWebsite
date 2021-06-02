# TripWebsite
Web service designed for my friend's company

## Used technology stack
Spring Boot 2<br>
Java 16<br>
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

### JSON object structure<br>
* Trip<br>
```LocalDate tripDate``` -> planned date of trip<br>
```LocalDate orderDate``` -> should be empty, it is going to be filled while backend process ends with success<br>
```String personName``` -> name of person, who should be visible on order pdf<br>
```int normalTickets``` -> number of normal tickets<br>
```int reducedTickets``` -> number of reduced tickets<br>
```double tripCost``` -> calculated full trip cost<br>
```String voucherNumber``` -> should be empty, it is going to be generated after success backend validation<br>
```User user``` -> object of user (hotel) which made order<br>
```Destination destination``` -> object of destination of the trip<br>
```boolean isTripActive``` -> flag showing if trip is active, or not (eg. cancelled by ordering person)<br>

* Destination<br>
```String destination``` destination name<br>
```double normalPrice``` normal price of trip<br>
```reducedPrice``` reduced price of trip<br>
```List<Trip> trips``` trips to this destination<br>

* User<br>
```String username``` username and login<br>
```String email``` an e-mail address connected with account<br>
```String password``` password to account<br>
```String fullHotelName``` full hotel name. It will appear in every order done by this hotel and on main page.<br>
```LocalDateTime registerDate``` date and hour when account was registered<br>
```String hotelAddress``` address of hotel. It will appear in pdf generated from order<br>
```Set<RoleDTO> roles``` roles of the user. Could be USER or ADMIN<br>
```List<Trip> trips``` list of trips ordered by this user<br>