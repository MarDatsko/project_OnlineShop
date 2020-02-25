## Name: 
OnlineShop

### Requirements:
Java 11, Spring Boot 2, Spring Framework (Data, MVC, Security), JWT, Apache Maven, PostgreSQL 11,  Flyway, Apache Lombok, Docker & Docker compose **

### Goal: 
Write the API, which include functions recording various customer interactions over email, phone, social media or other channels; depending on system capabilities, automating various workflow automation processes, such as tasks, calendars and alerts; and giving managers the ability to track performance and productivity based on information logged within the system. 

Main  objects:
1. Category - name, description, image, userId
2. Position - name, price, description, availability, categoryId, userId
3. User: firstName, lastName, age, phone, accountId
4. Account: username, email, password, confirmPassword
5. Orders - date, orderNumber, userId, items(related to OrderItem), orderPrice
6. OrderItem: name, quantity, price


https://docs.google.com/document/d/1AQuTO8dIMLyzjKhuLXpreHN5OLgO61hVTKSJmAIBqu4/edit?usp=sharing
