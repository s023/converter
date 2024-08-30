# Converter Backend

## How to build

### Build the Frontend 

```shell
cd frontend
npm run build
```

### Copy Frontend Files to Backend

```shell
cp -r build/* ../backend/src/main/resources/static/
```

### Package the Application

```shell
mvn package spring-boot:repackage
```
## How to run

You can run this application:

1) From your IDE by importing this project first and then starting it.

2) From command line using built JAR file and following command:

```shell
java -jar backend/target/backend-0.0.1-SNAPSHOT.jar
```