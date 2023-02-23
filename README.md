# Hexagonal Architecture

### Requirements

- Java 17
- Gradle
- Docker
- docker-compose

### Run kafka container

```shell
docker-compose up -d
```

### Run application

```shell
./gradlew bootRun
```

### Generate test events

```http request
POST http://localhost:8080/event
```