
# Happy Travel ✈️

## Índice

- [Proyecto 📝](#proyecto-)
    - [Requisitos previos](#requisitos-previos-)
- [Diagramas](#diagrama-)
    - [Diagrama de flujo](#diagrama-de-flujo-)
    - [Diagrama de datos](#diagrama-de-datos-)
- [Instalación 🛠️](#installation-)
    - [Requerimientos](#requerimientos-)
- [Estructura del proyecto](#estructura-del-proyecto-)
- [Tecnologías](#tecnologias-)
- [Uso](#uso-)
- [Contribución 🤝](#contribution-)
- [Coders👩‍💻](#coders-)
- [Demo](#demo-)


## Proyecto 

Desarrollo de una aplicación de viajes en la que cada usuario puede ver, añadir, editar y eliminar destinos a los que quiere ir, además de ver los destinos de otros usuarios. 

La aplicación permite a los usuarios hacer login, y es a través de esta autenticación que tienen acceso a editar y eliminar sus destinos creados. 

En el proyecto se ha creado tanto la parte del Front on React js con Tailwind para el CSS partiendo de prototipos dados por el cliente, como toda la parte del Back con Java SpringBoot y PostgreSQL.


### Requisitos previos

**Funcionalidades**
- Poder ver todos los destinos
- Formulario de registro
- Formulario de acceso con e-mail y contraseña
- Al acceder, el usuario autenticado ve los botones de editar y eliminar en sus destinos
- Los usuarios regostrados pueden ver el detalle de cada destino
- Todas als acciones del usuario con CRUD o registro/acceso tienen alertas 
- Todos los formularios tienen validación y control de errores
- Cambio de iconos en navbar cuando el usuario accese a la app
- Buscador funcional para buscar por nombre de destino o ubicación
- Poder crear destinos 
- Poder editar destinos 


## Diagramas

### Diagrama de flujo

Para entender la funcionalidad de la aplicación y la lógica a seguir se ha realizado un diagrama de flujo. 

[Ver diagrama de flujo](https://www.figma.com/board/UrcrZr8sE18p3y7Mz1gyg4/Workflow-Happy-Travel?node-id=0-1&node-type=CANVAS&t=2OtyJqSwXlkkrn9y-0)

### Diagrama de datos

Se ha normalizado a segunda forma las tablas de la base de datos, resultando en dos tablas: una de destinos y una de usuarios. 

[Ver diagrama de datos](https://drive.google.com/file/d/10PgRGYlonrVyzvB59yHySvLqkj4b0A6J/view)



## Instalación 🛠️

### Requerimientos

- [Node.js](https://nodejs.org/en)
- [VSC](https://www.w3schools.com/java/java_intro.asp) con [extensión Java Pack VSC](vscjava.vscode-java-pack), [IntelliJ](https://www.jetbrains.com/es-es/idea/)  or tu IDE de preferencia
- Base de datos


1. Clona los repositorios:
```bash
Front:
 git clone https://github.com/LauraGDev/happy-travel-front

Back:
 git clone https://github.com/flaviferri/HappyTravel-BackEnd

```

2. Haz npm install en el repo del front

3. Crea tu base de datos y conectála al repo del back:
```
pon el link de acceso, tu usuario y contraseña de pgAdmin o de tu BBDD en el archivo application.resources

```




## Estructura del proyecto

Como proyecto Full-Stack, la estructura se divide en Front y en Back. 

El back del proyecto se ha realziado con Java SpringBoot, con una arquitectura MVC de 3 capas. 

La estructura final del back es la siguiente:

```plaintext
/
├── happy-travel-back
│   ├── src/
│   │    ├── main
│   │    │     ├── java
│   │    │     │      ├── config
│   │    │     │      │      ├── ApplicationConfig
│   │    │     │      │      └── SecurityConfig
│   │    │     │      ├── controllers
│   │    │     │      │      ├── AuthController
│   │    │     │      │      ├── AuthResponse
│   │    │     │      │      ├── DestinationController
│   │    │     │      │      ├── LoginRequest
│   │    │     │      │      ├── RegisterRequest
│   │    │     │      │      └── UserController
│   │    │     │      ├── jwt
│   │    │     │      │      └── JwtAuthenticationFilter
│   │    │     │      ├── models
│   │    │     │      │      ├── Destination
│   │    │     │      │      └── User
│   │    │     │      ├── repositories
│   │    │     │      │      ├── DestinationRepository
│   │    │     │      │      └── UserRepository
│   │    │     │      ├── role
│   │    │     │      │      └── Role
│   │    │     │      ├── services
│   │    │     │      │      ├── AuthService
│   │    │     │      │      ├── DestinationService
│   │    │     │      │      └── JwtService
│   │    │     │      └── HappyTravelApplication
│   │    │     └── resources
│   │    │          └── application.properties  
│   │    └── test
│   │        └── HappyTravelApplicationTests
│   ├── target
│   └── .mvn
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

```

## Tecnologías

**Front**
- [React.js](https://react.dev/)
- [JavaScript](https://www.w3schools.com/js/js_intro.asp)
- [TailwindCSS](https://tailwindcss.com/)

**Back**
- [Java](https://www.java.com)
- [PgAdmin](https://www.pgadmin.org/)+ [SQL](https://www.w3schools.com/sql/default.asp)
- [SpringBoot](https://spring.io/projects/spring-boot)



## Uso
El programa debe iniciarse primero en el back.

Para compilar:

```
Da al play para compilar automáticamente.

```

Una vez iniciado el back, en el front:

```
npm run dev
```

Abre el enlace que aparece con tu puerto local.


## Contribución 🤝

1. Haz un fork al repositorio.
2. Crea una nueva rama: `git checkout -b feature/name`.
3. Haz tus cambios.
4. Haz push de tu rama: `git push origin feature/name`.
5. Crea un pull request.


 ## Coders👩‍💻
Las coders que hemos trabajado en este proyecto somos:

- [Flavia Ferri](https://github.com/flaviferri)
- [Laura Gil](https://github.com/LauraGDev)
- [Betty Lopez](https://github.com/BettyLopo)
- [Ziortza Rey](https://github.com/indiakka)
- [Sara Terán](https://github.com/Sarii4)

## Demo
**Versión móvil:**

https://github.com/user-attachments/assets/84d2de90-dabd-43a7-a0e1-0ea6b68def39

**Versión desktop:**

<img width="864" alt="home-ht" src="https://github.com/user-attachments/assets/1fe9969e-18b9-4097-82cb-b4d6a06aacf6">
<img width="863" alt="register-ht" src="https://github.com/user-attachments/assets/2738c1bb-be3f-49fb-b101-c3d5192875d4">
<img width="863" alt="logiin" src="https://github.com/user-attachments/assets/8e815aeb-ca77-4de0-8a05-6b02403e9270">
<img width="866" alt="logged-home" src="https://github.com/user-attachments/assets/f17fba8c-f7f5-49ab-b022-f5fd9656a36a">
<img width="862" alt="Captura de pantalla 2024-08-29 a les 18 07 44" src="https://github.com/user-attachments/assets/e2b40a3e-34b0-4147-bc9b-6396e37c1818">
<img width="862" alt="Captura de pantalla 2024-08-29 a les 18 08 03" src="https://github.com/user-attachments/assets/5f2088b7-f7ec-4786-b097-a9185c426a4e">
<img width="861" alt="Captura de pantalla 2024-08-29 a les 18 08 31" src="https://github.com/user-attachments/assets/66a74ce4-940c-4d43-b486-d9dfc4ed4ed0">
<img width="866" alt="Captura de pantalla 2024-08-29 a les 18 08 48" src="https://github.com/user-attachments/assets/1e26ebf3-e81e-4a43-b701-29e80fd71f91">
<img width="863" alt="Captura de pantalla 2024-08-29 a les 18 09 28" src="https://github.com/user-attachments/assets/23e53536-e2ed-48fd-ab8e-f8cb9eb8df93">
<img width="861" alt="Captura de pantalla 2024-08-29 a les 18 09 46" src="https://github.com/user-attachments/assets/4b304808-f881-4c32-aa2b-98d6bd66303c">

