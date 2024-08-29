# Converter Backend

## How to build

In order to build application enter following command from parent (root) folder:

```shell
mvn package spring-boot:repackage
```

In folder `converter/target` you will have executable JAR file

### How to run

You can run this application:

1) From your IDE by importing this project first and then starting it.

2) From command line using built JAR file and following command:

```shell
java -jar converter/target/converter-0.0.1-SNAPSHOT.jar
```
### How to extend the solution

The converter/strategies is a suitable place to add another converter. 