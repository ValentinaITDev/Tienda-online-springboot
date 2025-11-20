# Tienda Online Spring Boot

API REST para una tienda online con Spring Boot, Spring Security y JWT.

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.7
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Requisitos

- JDK 21 o superior
- Maven 3.6+

## Configuración

La aplicación utiliza H2 como base de datos en memoria. La configuración se encuentra en `application.properties`.

## Ejecutar la aplicación

En Windows:
```bash
mvnw.cmd spring-boot:run
```

En Linux/Mac:
```bash
./mvnw spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## Acceso a H2 Console

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:tiendadb`
- Usuario: `sa`
- Contraseña: (dejar vacío)

## Usuarios de prueba

La aplicación carga automáticamente 5 usuarios:

| Nombre | Correo | Contraseña |
|--------|--------|-----------|
| Juan Pérez | juan.perez@email.com | Qwerty123 |
| Ana Gómez | ana.gomez@email.com | Pass456 |
| Carlos Ruiz | carlos.ruiz@email.com | Segura789 |
| Sofía Martínez | sofia.martinez@email.com | Clave987 |
| Diego Fernández | diego.fernandez@email.com | Contra654 |

## Datos iniciales

Al iniciar la aplicación se cargan automáticamente:
- 5 Usuarios
- 5 Categorías (Electrónica, Ropa, Hogar, Deportes, Libros)
- 50 Productos
- 50 Comentarios

## Endpoints disponibles

### Endpoints públicos (no requieren autenticación)

**Login**
```
POST /auth/login
Content-Type: application/json

{
  "correoElectronico": "juan.perez@email.com",
  "contrasena": "Qwerty123"
}
```

**Listar productos con bajo stock**
```
GET /productos/bajo-stock?x=15
```

**Listar comentarios desde una fecha**
```
GET /comentarios/desde?fecha=2025-05-10
```

### Endpoints privados (requieren JWT)

Para usar estos endpoints, incluir el token en el header:
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
2. Hacer login para obtener el token JWT
3. Usar el token en los endpoints privados

## Funcionalidades implementadas

- Autenticación con JWT
- Contraseñas encriptadas con BCrypt
- Gestión de carritos de compra
- Control automático de stock
- Cálculo automático de impuestos (19%)
- Validación de pertenencia de recursos

## Notas importantes

- La base de datos H2 es en memoria, los datos se pierden al reiniciar la aplicación
- El token JWT expira en 24 horas
- Al agregar un producto al carrito, el stock se descuenta automáticamente
- Solo el propietario del carrito puede modificarlo
