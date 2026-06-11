# Unidad 2 - Spring Boot MVC CRUD

## Caso trabajado

- CRUD base de las guías: **Usuarios**.
- CRUD del ejercicio/caso asignado: **Restaurante / Pedido / Número de pedido**.

## Ejecutar

```bash
mvn spring-boot:run
```

Luego abrir:

- Página principal: `http://localhost:8080/`
- CRUD usuarios: `http://localhost:8080/usuarios`
- CRUD pedidos: `http://localhost:8080/pedidos`
- Consola H2: `http://localhost:8080/h2-console`

Datos H2:

- JDBC URL: `jdbc:h2:mem:unidad2db`
- User: `sa`
- Password: vacío

## Estructura principal

```text
src/main/java/com/udec/unidad2mvc
├── controller
├── model
├── repository
├── service
└── Unidad2MvcApplication.java
src/main/resources
├── static/css/styles.css
├── templates
│   ├── index.html
│   ├── usuarios
│   └── pedidos
├── application.properties
└── data.sql
```

## Funcionalidades

- Listar usuarios y pedidos.
- Registrar nuevos usuarios y pedidos.
- Editar información existente.
- Eliminar registros con confirmación.
- Validar formularios con mensajes de error.
- Separar la aplicación por capas MVC.

