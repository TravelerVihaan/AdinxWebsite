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

### JSON object structure
* Trip
```LocalDate tripDate``` -> planned date of trip
```LocalDate orderDate``` -> should be empty, it is going to be filled while backend process ends with success
```String personName``` -> name of person, who should be visible on order pdf
```int normalTickets``` -> number of normal tickets
```int reducedTickets``` -> number of reduced tickets
```double tripCost``` -> calculated full trip cost
```String voucherNumber``` -> should be empty, it is going to be generated after success backend validation
```User user``` -> object of user (hotel) which made order
```Destination destination``` -> object of destination of the trip
```boolean isTripActive``` -> flag showing if trip is active, or not (eg. cancelled by ordering person)

* Destination
```String destination``` destination name
```double normalPrice``` normal price of trip
```reducedPrice``` reduced price of trip
```List<Trip> trips``` trips to this destination

*User
```String username``` username and login
```String email``` an e-mail address connected with account
```String password``` password to account
```String fullHotelName``` full hotel name. It will appear in every order done by this hotel and on main page.
```LocalDateTime registerDate``` date and hour when account was registered
```String hotelAddress``` address of hotel. It will appear in pdf generated from order
```Set<RoleDTO> roles``` roles of the user. Could be USER or ADMIN
```List<Trip> trips``` list of trips ordered by this user