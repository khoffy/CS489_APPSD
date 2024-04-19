# Documentation page to test the API
http://localhost:8080/swagger-ui.html

# Add Docker Compose Support dependency
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-docker-compose</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

# Docker compose set up
version: '3.7'
services:
    postgres:
        image: 'postgres:latest'
        environment:
            - 'POSTGRES_DB=<database_name>'
            - 'POSTGRES_PASSWORD=<password>'
            - 'POSTGRES_USER=<username>'
        ports:
            - '5432:5432'

    pgadmin:
        image: 'dpage/pgadmin4:latest'
        environment:
            PGADMIN_DEFAULT_EMAIL: <your_email>
            PGADMIN_DEFAULT_PASSWORD: <password>
            PGADMIN_LISTEN_PORT: 5050
        ports:
            - '5050:5050'

    app:
        image: 'ads-dental-surgeries'
        ports:
            - '80:8080'

# Access to pgAdmin
* Launch PgAdmin at http://localhost:5050
  * Provide email/password to connect > click on “Servers” > “Register” > “Server” >
        “Name”: <db_name>
        “Connection” : Host name/address: ($ docker inspect <db_container_name> | grep IPAddress),
            to get the database ip address, then provide the database username/password
