# Getting Started

Pasos para generar el proyecto:

1. Crear un nuevo proyecto con Spring initializr. Elegir Java, Maven, colocar como nombre raíz del grupo io.newschool.platform.u (De acuerdo a lo que indica el enunciado), colocar como package name io.newschool.platform.u . Para JDK se recomienda 20 Oracle OpenJDK v 20.0.1, pero yo usé openjdk-21 java version "21.0.1". Después, elegir Java 17 y packaging Jar.
2. Elegir Spring Boot 3.1.4 y agregar las dependencias: <br>
Spring Boot DevTools <br>
Lombok <br>
Spring Modulith <br>
Spring Web <br>
Spring Data JPA <br>
MySQL Driver <br>
Validation <br>
3. Crear la carpeta application dentro de src/main/java/io/newschool/platform/u/profiles. En ella, crear la carpeta internal.
4. Dentro de la carpeta application/internal, crear las carpetas commandservices, eventhandlers, outboundservices, queryservices
5. Crear la carpeta domain dentro de src/main/java/io/newschool/platform/u/profiles. En ella, crear las carpetas model, services
6. Dentro de domain/model, crear las carpetas aggregates, commands, entities, events, queries, valueobjects
7. Crear la carpeta infrastructure dentro de src/main/java/io/newschool/platform/u/profiles. En ella, crear la carpeta persistence
8. Dentro de infrastructure/persistence, crear la carpeta jpa. Dentro de ella, repositories
9. Crear la carpeta interfaces dentro de src/main/java/io/newschool/platform/u/profiles. En ella, crear la carpeta rest
10. Dentro de interfaces/rest, crear las carpetas resources y transform
11. En profiles/domain/model/valueobjects crear StudentName, StudentDni y StudentName. Recordar colocar @Embeddable
12. Crear la carpeta shared dentro de src/main/java/io/newschool/platform/u/profiles. En ella, crear las carpetas domain, infrastructure.
13. Dentro de shared/domain, crear la carpeta model, dentro de ella, la carpeta entitites.
14. Dentro de shared/infrastructure, crear la carpeta persistence. Dentro de ella, la carpeta jpa. En jpa pegar el archivo SnakeCasePhysicalNamingStrategy. Agregar a pom.xml lo siguiente: <br>
    `<!--https://mvnrepository.com/artifact/io.github.encryptorcode/pluralize -->
    <dependency>
    <groupId>io.github.encryptorcode</groupId>
    <artifactId>pluralize</artifactId>
    <version>1.0.0</version>
    </dependency>
    <dependency>`
    <br>
15. Dentro de shared/infrastructure crear la carpeta documentation. Copiar y pegar los contenidos. Importar las dependencias en el pom.xml
16. En profiles/domain/model/aggregates crear la clase Student. Agregar los atributos necesarios como private, agregar @Entity a la clase, así como @Id y @Getter al id
17. En profiles/domain/model/commands crear el record CreateStudentCommand
18. En profiles/infrastructure/persistence/jpa/repositories crear StudentRepository
19. En profiles/interfaces/rest/resources crear CreateStudentResource y StudentResource

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web)
* [Validation](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#io.validation)
* [Spring Modulith](https://docs.spring.io/spring-modulith/docs/current/reference/html/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#using.devtools)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

