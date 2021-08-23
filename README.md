# API de REST - Muévete por los que no pueden

## Descripción

[Muévete por los que no pueden](https://mueveteporlosquenopueden.org/) es una organización sin ánimo de lucro conducida por voluntarios. Sus objetivos son divulgar y concienciar sobre las enfermedades raras o minoritarias, recaudar fondos para su investigación e impulsar el deporte.

Necesitan una aplicación web y móvil que sea accesible y les ayude a automatizar procesos que actualmente realizan de forma manual.

## Enlaces

Frontend: https://muevete.netlify.app - Repositorio: https://github.com/nuwe-cowboy/frontend

Backend: https://mplqnp.herokuapp.com

## Stack

- Java
- Gradle
- Spring Framework
- MongoDB Atlas (persistencia)
- Heroku (despliegue)
- Postman (testeo)

## Endpoints

| Método | Endpoint | Request body | Rol | Descripción |
| :---: | :---: | :---: | :---: | :--- |
| `GET` | `/` | | | Devuelve la versión de la API. |

```json
{
	"appVersion": "0.0.1"
}
```

- Autenticación y autorización con JSON Web Tokens (JWT).
- Encriptación con BCryptPasswordEncoder.

| Método | Endpoint | Request body | Rol | Descripción |
| :---: | :---: | :---: | :---: | :--- |
| `POST` | `/login` | username, password | | Devuelve un token. |

```json
{
	"username": "test@example.com",
	"password": "123456"
}
```

### Users

Usuarios registrados.

| Método | Endpoint | Request body | Rol | Descripción |
| :---: | :---: | :---: | :---: | :--- |
| `GET` | `/users` | | `ADMIN` | Devuelve todos los usuarios. |
| `GET` | `/users/{id}` | | `DEFAULT` o `ADMIN` | Devuelve un usuario. |
| `POST` | `/users/default` | User | | Crea un usuario con el rol `DEFAULT`. |
| `POST` | `/users/admin` | User | `ADMIN` | Crea un usuario con el rol `ADMIN`. |
| `PUT` | `/users/{id}` | User | `ADMIN` | Actualiza un usuario. |
| `DELETE` | `/users/{id}` | | `ADMIN` | Elimina un usuario. |

```json
{
	"id": "11110000-0000-0000-0000-000000000000",
	"name": "John",
	"lastName": "Doe",
	"email": "test@example.com",
	"password": "123456",
	"role": "DEFAULT"
}
```

### Articles

Artículos publicados en la revista.

| Método | Endpoint | Request body | Rol | Descripción |
| :---: | :---: | :---: | :---: | :--- |
| `GET` | `/articles` | | | Devuelve todos los artículos. |
| `GET` | `/articles/{id}` | | | Devuelve un artículo. |
| `POST` | `/articles` | Article | `ADMIN` | Crea un artículo. |
| `PUT` | `/articles/{id}` | Article | `ADMIN` | Actualiza un artículo. |
| `DELETE` | `/articles/{id}` | | `ADMIN` | Elimina un artículo. |

```json
{
	"id": "11110000-0000-0000-0000-000000000000",
	"title": "Lorem ipsum",
	"body": "Dolor sit amet",
	"timestamp": "01-01-2001 00:00:00"
}
```

### Events

Eventos deportivos.

| Método | Endpoint | Request body | Rol | Descripción |
| :---: | :---: | :---: | :---: | :--- |
| `GET` | `/events` | | | Devuelve todos los eventos. |
| `GET` | `/events/{id}` | | | Devuelve un evento. |
| `POST` | `/events` | Event | `ADMIN` | Crea un evento. |
| `PUT` | `/events/{id}` | Event | `ADMIN` | Actualiza un evento. |
| `DELETE` | `/events/{id}` | | `ADMIN` | Elimina un evento. |

```json
{
	"id": "11110000-0000-0000-0000-000000000000",
	"title": "Lorem ipsum",
	"body": "Dolor sit amet",
	"goal": 100,
	"timestamp": "01-01-2001 00:00:00"
}
```

### UserEvents

Relación many-to-many. Inscripciones a eventos.

| Método | Endpoint | Request body | Rol | Descripción |
| :---: | :---: | :---: | :---: | :--- |
| `GET` | `/users/{userId}/events` | | `DEFAULT` o `ADMIN` | Devuelve todas las inscripciones a eventos de un usuario. |
| `GET` | `/events/{eventId}/users` | | | Devuelve todos los usuarios inscritos a un evento. |
| `POST` | `/users/{userId}/events/{eventId}` | | `DEFAULT` o `ADMIN` | Crea una inscripción. |
| `PUT` | `/users/{userId}/events/{eventId}` | UserEvent | `DEFAULT` o `ADMIN` | Actualiza una inscripción. |
| `DELETE` | `/users/{userId}/events/{eventId}` | | `DEFAULT` o `ADMIN` | Elimina una inscripción. |

```json
{
	"id": "11110000-0000-0000-0000-000000000000",
	"userId": "11110000-0000-0000-0000-000000000000",
	"eventId": "11110000-0000-0000-0000-000000000000",
	"distance": 2.5
}
```

## Estructura

```
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── configuration/
│   │   │           │   ├── WebMvcConfiguration.java
│   │   │           │   └── WebSecurityConfiguration.java
│   │   │           ├── controller/
│   │   │           │   ├── exception/
│   │   │           │   │   ├── CustomExceptionResponse.java
│   │   │           │   │   ├── GlobalRestControllerAdvice.java
│   │   │           │   │   └── ResourceNotFoundException.java
│   │   │           │   ├── ArticleRestController.java
│   │   │           │   ├── EventRestController.java
│   │   │           │   ├── UserEventRestController.java
│   │   │           │   └── UserRestController.java
│   │   │           ├── domain/
│   │   │           │   ├── Article.java
│   │   │           │   ├── ERole.java
│   │   │           │   ├── Event.java
│   │   │           │   ├── User.java
│   │   │           │   └── UserEvent.java
│   │   │           ├── repository/
│   │   │           │   ├── IArticleRepository.java
│   │   │           │   ├── IEventRepository.java
│   │   │           │   ├── IUserEventRepository.java
│   │   │           │   └── IUserRepository.java
│   │   │           ├── security/
│   │   │           │   ├── Filter.java
│   │   │           │   ├── HomeController.java
│   │   │           │   ├── TokenRestController.java
│   │   │           │   └── TokenService.java
│   │   │           ├── service/
│   │   │           │   ├── ArticleService.java
│   │   │           │   ├── EventService.java
│   │   │           │   ├── UserEventService.java
│   │   │           │   └── UserService.java
│   │   │           └── App.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── testing.postman_collection.json
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── AppTests.java
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
├── Procfile
├── README.md
├── settings.gradle
└── system.properties
```

## Dependencias

- [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- [Spring Boot DevTools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
- [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)
- [Spring Boot Starter Data MongoDB](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb)
- [Spring Boot Starter Validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)
- [Bean Validation API](https://mvnrepository.com/artifact/javax.validation/validation-api)
- [Spring Boot Starter Security](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)
- [JSON Web Token Support For The JVM](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt)
- [JAXB API](https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api)
- [Spring Boot Starter Mail](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-mail)

## Para desarrolladores

Pasos a seguir:

1. Clona el proyecto:
	
	`git clone https://github.com/nuwe-cowboy/backend`

#### Línea de comandos

2. Ejecución:
	1. En Windows: `gradlew.bat bootRun`
	2. En Linux: `./gradlew bootRun`

#### Eclipse

2. Importación:
	
	`File` > `Import…` > `Existing Gradle Project` > `Seleccionar el directorio raíz del proyecto` > `Finish`
3. Ejecución:
	
	`Package Explorer` > `Click derecho encima del nombre del proyecto` > `Run As` > `Spring Boot App`

4. Si incluyes nuevas dependencias en `build.gradle`:
	
	`Package Explorer` > `Click derecho encima del nombre del proyecto` > `Gradle` > `Refresh Gradle Project`

#### IntelliJ IDEA

2. Importación:
	
	`File` > `Open` > `Seleccionar el archivo build.gradle del proyecto` > `Open` > `Open as Project` > `Trust Project`
3. Ejecución:
	
	`Run` > `Run App`
	
	o bien:
	
	`Click derecho encima del main` > `App` > `Run App`

### Cómo contribuir

1. Crea una rama a partir de la rama «develop»:
	
	`git checkout develop` > `git checkout -b funcionalidad`
	
	Sustituye «funcionalidad» por un nombre representativo de la funcionalidad que quieres incorporar.
	
2. Cuando esté lista la funcionalidad, sube tu rama al repositorio remoto:
	
	`git push origin funcionalidad`
	
3. [Crea un Pull Request](https://github.com/nuwe-cowboy/backend/pulls):
	
	`base: develop 🡐 compare: funcionalidad`
	
#### Gitflow

```
┌── origin/master, heroku/main
└── origin/develop
    └── origin/funcionalidad
```

*Made with :heart: by Nuwe Cowboy Team*
