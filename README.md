# Tienda Online Spring Boot

API REST para una tienda online desarrollada con Spring Boot, Spring Security y JWT.

## Tecnologías

- Java 21
- Spring Boot 3.5.7
- Spring Security
- JWT
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Requisitos

- JDK 21 o superior
- Maven 3.6+

## Configuración

La aplicación usa H2 como base de datos en memoria. La configuración está en `application.properties`.

## Ejecutar la aplicación

```bash
./mvnw.cmd spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## Acceso a H2 Console

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:tiendadb`
- Usuario: `sa`
- Contraseña: (vacío)

## Usuarios precargados

| ID | Nombre | Correo | Contraseña |
|----|--------|--------|-----------|
| 1 | Juan Pérez | juan.perez@email.com | Qwerty123 |
| 2 | Ana Gómez | ana.gomez@email.com | Pass456 |
| 3 | Carlos Ruiz | carlos.ruiz@email.com | Segura789 |
| 4 | Sofía Martínez | sofia.martinez@email.com | Clave987 |
| 5 | Diego Fernández | diego.fernandez@email.com | Contra654 |

## Datos iniciales

La aplicación carga automáticamente:
- 5 Usuarios
- 5 Categorías (Electrónica, Ropa, Hogar, Deportes, Libros)
- 50 Productos
- 50 Comentarios

## Endpoints

### Públicos (sin autenticación)

**Login**
```
POST /auth/login
Content-Type: application/json

{
  "correoElectronico": "juan.perez@email.com",
  "contrasena": "Qwerty123"
}
```

**Productos con bajo stock**
```
GET /productos/bajo-stock?x=15
```

**Comentarios desde una fecha**
```
GET /comentarios/desde?fecha=2025-05-10
```

### Privados (requieren JWT)

Incluir el token en el header:
```
Authorization: Bearer {token}
```

**Crear carrito**
```
POST /carrito
```

**Agregar producto al carrito**
```
POST /carrito/{idCarrito}/agregar-producto/{idProducto}
```

**Obtener productos del carrito**
```
GET /carrito/{idCarrito}/productos
```

## Estructura del proyecto

```
src/main/java/com/tienda/
├── config/              - Configuraciones
├── controller/          - Controladores REST
├── dto/                 - Data Transfer Objects
├── entity/              - Entidades JPA
├── repository/          - Repositorios
├── security/            - Seguridad y JWT
└── service/             - Servicios
```

## Probar con Postman

1. Importar el archivo `Tienda-Online-Postman-Collection.json`
2. Hacer login para obtener el token
3. Usar el token en los endpoints privados

## Características

- Autenticación con JWT
- Contraseñas encriptadas con BCrypt
- Gestión de carritos de compra
- Control automático de stock
- Cálculo automático de impuestos (19%)
- Validación de pertenencia de recursos

## Notas

- La base de datos H2 es en memoria, los datos se pierden al reiniciar
- El token JWT expira en 24 horas
- Solo el propietario del carrito puede modificarlo
