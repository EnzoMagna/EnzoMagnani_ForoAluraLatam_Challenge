ForoAluraLatam - API

Este proyecto es un backend REST para la gestión de tópicos, con autenticación JWT.

REQUISITOS:
- Java 21
- MySQL
- Spring Boot 3.x
- Insomnia

AUTENTICACIÓN:
Antes de enviar requests a los endpoints protegidos, es necesario loguearse:

Endpoint de login: POST http://localhost:8080/login
Body (JSON):
{
  "login": "usuario@example.com",
  "clave": "tu-contraseña"
}

La respuesta será un JWT que debe usarse en los headers de los requests protegidos:
Authorization: Bearer <tu-token>

En Insomnia:
1. Crear un Environment con la variable jwt.
2. Configurar la carpeta de requests con tipo Bearer Token y poner {{ jwt }} como token.
3. Todos los requests de esa carpeta usarán automáticamente ese token.

ENDPOINTS DE TÓPICOS:
Todos los endpoints requieren autenticación:

- Obtener todos los tópicos:
  GET http://localhost:8080/topicos

- Obtener un tópico por ID:
  GET http://localhost:8080/topicos/id

- Crear un tópico:
  POST http://localhost:8080/topicos
  Body ejemplo (JSON):
  {
	"titulo":"¿Cómo crear una nueva app en Spring Boot?",
	"mensaje":"Me gustaría saber cómo se puede crear una aplicación con Spring Boot desde cero. He escuchado que hay que configurar el proyecto con Maven o Gradle,
definir las dependencias necesarias y estructurar correctamente los paquetes para los controladores, servicios y repositorios.
Además, me interesa entender cómo se integran las bases de datos y cómo se pueden exponer endpoints REST de manera segura y eficiente,
asegurando que la aplicación pueda escalar correctamente y mantener un buen rendimiento"
,
	"autor":"Ezio Lamas",
	"curso":"SPRING_BOOT"
}

- Borrar un tópico por ID:
  DELETE http://localhost:8080/topicos/id

USO CON INSOMNIA:
1. Loguear el usuario para obtener el token.
2. Configurar el token en la carpeta de tópicos.
3. Enviar los requests HTTP (GET, POST, DELETE) a http://localhost:8080/topicos según corresponda.
