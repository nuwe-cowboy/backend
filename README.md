# "Muévete por los que no pueden"
## Summer Coding League - API REST

## Descripción
En "Muévete por los que no pueden", realizan eventos deportivos y por lo tanto necesitan 
una API para gestionar todos estos acontecimientos.


## Stack Tecnológico
- Java
- Spring Boot
- Gradle
- MongoDB
- [Heroku](https://www.heroku.com/)


## Endpoints

### Usuarios

Usuarios registrados.

| Método | Endpoint | Request body | Descripción |
| :---: | :---: | :---: | :--- |
| `GET` | `/users` | | Devuelve todos los usuarios. |
| `GET` | `/users/{id}` | | Devuelve un usuario a partir de su ID. |
| `POST` | `/users` | User | Crea un nuevo usuario. |
| `PUT` | `/users/{id}` | User | Actualiza un usuario a partir de su ID. |
| `DELETE` | `/users/{id}` | | Elimina un usuario a partir de su ID. |

User: name, lastName, password, email

### Artículos

Artículos publicados en el newsletter.

| Método | Endpoint | Request body | Descripción |
| :---: | :---: | :---: | :--- |
| `GET` | `/articles` | | Devuelve todos los artículos. |
| `GET` | `/articles/{id}` | | Devuelve un artículo a partir de su ID. |
| `POST` | `/articles` | Article | Crea un nuevo artículo. |
| `PUT` | `/articles/{id}` | Article | Actualiza un artículo a partir de su ID. |
| `DELETE` | `/articles/{id}` | | Elimina un artículo a partir de su ID. |

Article: title, description, timestamp

### Eventos

Eventos deportivos.

| Método | Endpoint | Request body | Descripción |
| :---: | :---: | :---: | :--- |
| `GET` | `/events` | | Devuelve todos los eventos. |
| `GET` | `/events/{id}` | | Devuelve un evento a partir de su ID. |
| `POST` | `/events` | Event | Crea un nuevo evento. |
| `PUT` | `/events/{id}` | Event | Actualiza un evento a partir de su ID. |
| `DELETE` | `/events/{id}` | | Elimina un evento a partir de su ID. |

Event: title, description, target, timestamp

## Estructura de proyecto

```
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── controller/
│   │   │           │   ├── exception/
│   │   │           │   │   ├── GlobalRestControllerAdvice.java
│   │   │           │   │   └── ResourceNotFoundException.java
│   │   │           │   ├── ArticleRestController.java
│   │   │           │   ├── EventRestController.java
│   │   │           │   └── UserRestController.java
│   │   │           ├── domain/
│   │   │           │   ├── Article.java
│   │   │           │   ├── Event.java
│   │   │           │   └── User.java
│   │   │           ├── repository/
│   │   │           │   ├── IArticleRepository.java
│   │   │           │   ├── IEventRepository.java
│   │   │           │   └── IUserRepository.java
│   │   │           ├── service/
│   │   │           │   ├── ArticleService.java
│   │   │           │   ├── EventService.java
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

## Para desarrolladores

Pasos a seguir:

1. Clona el proyecto:   
```git clone https://github.com/nuwe-cowboy/backend```.

#### Línea de comandos

2. Ejecución:  
- En Windows  
```gradlew.bat bootRun```  
- en Linux  
  ```./gradlew bootRun```

#### Eclipse

2. Importación: 
```
File > Import… > Existing Gradle Project
```
3. Ejecución: 
```
Package Explorer > Click derecho encima del nombre del proyecto > Run As > Spring Boot App.
```

Si incluyes nuevas dependencias en `build.gradle`:

4. Package Explorer > Click derecho encima del nombre del proyecto > Gradle > Refresh Gradle Project.

#### IntelliJ IDEA
2. Importación:
```
File > Open > Seleccionar el build.gradle del proyecto > Open > Open as Project > Trust Project
```

3. Ejecución:
```
Run > Run App
```
- o bien
```
Clic derecho en el main de la app: App > Run App
```

## Links
### Git
- [Git Frontend Repository](https://github.com/nuwe-cowboy/frontend)
- [Git Backend Repository](https://github.com/nuwe-cowboy/backend)


### Deploy
- [Frontend Deploy](https://muevete.netlify.app/)
- [Backend Deploy](https://mplqnp.herokuapp.com/)


Made with :heart: by Nuwe Cowboy Team
