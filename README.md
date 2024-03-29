# FizzBuzz API

FizzBuzz is an API allowing consumers to view fizzbuzzes and create them. The API provides a comprehensive platform for managing fizzbuzzes, allowing users to list all fizzbuzzes, view the details of an individual fizzbuzz, or create a new fizzbuzz. The API also offers powerful search capabilities, enabling users to find fizzbuzzes quickly and effectively.

## Technologies Used

* Java 17
* Maven
* Spring Boot
* Spring Data (JPA)
* H2 Database
* Postman
* Apache Tomcat 
* MockMVC 
* IntelliJ



## General Approach

I started off by creating my user stories and acceptance criteria. This helped me visualize my end goals and outline what I wanted to achieve with this project. I also created a spreadsheet of all my HTTP methods and endpoints to keep track of which methods were supposed to hit which endpoint.

Finally, I created an ERD (entity relationship diagram) to plan my different models and their relevant attributes. This helped me to visualize their relationships to one another and plan out how I was going to link the corresponding tables in the database.



## Entity Relationship Diagram

<img src="./images/FizzbuzzERD.png" alt="ERD">



## User Stories

<b>User Story 1:</b>
<br>
As a user, I want to be able to list all fizzbuzzes so that I can view all fizzbuzzes. (GET all fizzbuzzes)

<b>Acceptance Criteria:</b>
<br>
* User can list all fizzbuzz objects.
* Search results should display a list of all fizzbuzzes.


<b>User Story 2:</b>
<br>
As a user, I want to be able to retrieve a single fizzbuzz object so that I can view its specific details (user agent, creation date, and message). (GET individual fizzbuzz by fizzbuzz ID)

<b>Acceptance Criteria:</b>
<br>
* User can retrieve a single fizzbuzz object.
* Search results should return an exact match to the user's search criteria.


<b>User Story 3:</b>
<br>
As a user, I want to be able to create a new fizzbuzz object so that I can save it. (POST fizzbuzz)

<b>Acceptance Criteria:</b>
<br>
* User can create a new fizzbuzz object.
* User can save newly created fizzbuzz objects.



## HTTP Endpoints

| Request Type | URL              | Functionality        | Access | 
|--------------|------------------|----------------------|--------|
| POST         | /api/fizzbuzz/   | Create fizzbuzz      | Public |
| GET          | /api/fizzbuzz/   | Get all fizzbuzzes   | Public |
| GET          | /api/fizzbuzz/1/ | Get single fizzbuzz  | Public |



## Major Hurdles

Although all my endpoints work fine in Postman with no issues, I was only able to get 2 of my 3 tests to pass when using MockMVC to test my controller. The problem lies in the test for the POST method, so I know it's just a matter of me doing more research into how to refactor the logic for one particular line in that test. 

Unfortunately, I was working on a very short deadline for this project, but I do plan on continuing to work on it in order to correct this issue. 



### Links
* User Stories - https://docs.google.com/document/d/1viJjuitQMFVt2MorLFZDaMloTSTEtss5ngITOS-lnDI/edit?usp=drive_link 

* HTTP requests/endpoints spreadsheet - https://docs.google.com/spreadsheets/d/1ft-ChXrkbnJuuh9GB2JBouI0cmy8hgnQB66kLevDEUc/edit?usp=drive_link 



### Author

:woman_technologist: Erica Ayala

* [LinkedIn](https://www.linkedin.com/in/ayalavirtual)

* [GitHub](https://www.github.com/AyalaVirtual) 



