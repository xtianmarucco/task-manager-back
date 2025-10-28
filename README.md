# Task Manager Backend - Spring Boot

Este proyecto es el backend del desafío Full Stack para la aplicación de gestión de tareas. Utiliza Spring Boot, Spring Security y autenticación basada en JWT para proteger los endpoints.

## 🔧 Tecnologías utilizadas

* Java 17
* Spring Boot 3
* Spring Security
* JWT (JSON Web Tokens)
* PostgreSQL
* Maven

## 📦 Estructura del proyecto

```
src/main/java/org/taskmanager/taskmanagerback
├── config                # Configuración de seguridad y JWT
│   ├── SecurityConfig.java
│   └── JwtAuthFilter.java
├── controller            # Controladores REST
│   ├── AuthController.java
│   └── TaskController.java
├── model                 # Entidades JPA
│   ├── Task.java
│   └── User.java
├── repository            # Repositorios JPA
│   ├── TaskRepository.java
│   └── UserRepository.java
├── service               # Lógica de negocio
│   ├── TaskService.java
│   └── CustomUserDetailsService.java
└── util                  # Utilidades (JWT)
    └── JwtUtils.java
```

## ▶️ Ejecución del proyecto

1. Clonar el repositorio
2. Asegurarse de tener una base de datos PostgreSQL corriendo con una tabla `users` y `tasks`
3. Configurar `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

4. Ejecutar la aplicación desde tu IDE o con:

```bash
mvn spring-boot:run
```

---

## 🔐 Autenticación JWT

### Endpoint de Login

```http
POST /api/auth/login
```

**Body (JSON):**

```json
{
  "email": "usuario@mail.com",
  "password": "contraseña"
}
```

**Respuesta exitosa:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

Este token debe ser enviado en el header `Authorization` para acceder a los endpoints protegidos:

```
Authorization: Bearer {token}
```

---

## 📋 Endpoints disponibles

### Tareas (Protegidos con JWT)

* `GET /api/tasks` → Listar tareas
* `POST /api/tasks` → Crear nueva tarea
* `DELETE /api/tasks/{id}` → Eliminar tarea

---

## 👥 Usuarios de prueba

La app inicializa los siguientes usuarios en la base de datos (password: `1234asdfAA`):

| Email                                                           | Nombre            | Position           |
| --------------------------------------------------------------- | ----------------- | ------------------ |
| [christian.marucco@mail.com](mailto:christian.marucco@mail.com) | Christian Marucco | Frontend Developer |
| [carlosgomez@gmail.com](mailto:carlosgomez@gmail.com)           | Carlos Gómez      | Backend Developer  |
| [lucia.torres@hotmail.com](mailto:lucia.torres@hotmail.com)     | Lucía Torres      | QA Analyst         |
| [marcos.diaz@hotmail.com](mailto:marcos.diaz@hotmail.com)       | Marcos Díaz       | UX/UI Designer     |

---

## 🧪 Test de login con Postman

1. Hacer un `POST` a `/api/auth/login` con email y password.
2. Copiar el token JWT de la respuesta.
3. Realizar un `GET` a `/api/tasks` con el header:

   ```
   Authorization: Bearer {token}
   ```

---

## ✅ Pendientes / Próximos pasos

* Registro de usuarios
* Edición de tareas
* Filtros y búsqueda por estado
* Expiración de token y refresh tokens

---

## 🧠 Autor

Desarrollado por Christian Marucco — como parte del Desafío Full Stack (Vue 3 + Spring Boot).
