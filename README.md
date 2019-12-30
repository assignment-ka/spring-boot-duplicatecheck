Use Spring Initialr to create application base code.

Change HTTP port (if required)
    edit value in -
        spring-boot-duplicatecheck/src/main/resources/application.properties

Test
    ./mvnw test

Run
    ./mvnw spring-boot:run

Browser
    http://localhost:8888/opaquetoken

Terminal
    Insert a record
        curl -i -X POST -H "Content-Type:application/json" -d "{  \"value\" : \"12345\" }" http://localhost:8888/opaquetoken

    Find by value
        Browser
            http://localhost:8888/opaquetoken/search/findByValue?value=12345

Browser (assignment)
    http://localhost:8888/key?value=12345
