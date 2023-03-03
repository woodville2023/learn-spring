Prerequisites
--
    Java Developoment Kit 11 higher
    Apache Maven 3.8.4 or higher

Database
--
    If using different database replace properties
    in project_home/src/main/resources/application.properties
```
##replace the property values if different database
    #the url for the database
    spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
##the username for the database
    spring.datasource.username=jboss
##the password for the database
    spring.datasource.password=   
##the datasource.driver-class for the database
    spring.datasource.driver-class-name=org.postgresql.Driver           
##hibernate dialect
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL82Dialect
```
Build Application
--
    From the project folder
        mvn clean install
Run Application
--
    From the project folder
        java -jar target/demo.jar


