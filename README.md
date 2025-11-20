# 🛒 Tienda Online Spring Boot

Aplicación de comercio electrónico desarrollada con Spring Boot 3.x, Spring Security, JWT y H2 Database.

## 🚀 Tecnologías

- Java 21
- Spring Boot 3.5.7
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## 📋 Requisitos Previos

- JDK 21 o superior
- Maven 3.6+

## ⚙️ Configuración

La aplicación usa H2 como base de datos en memoria. La configuración está en `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:tiendadb
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## 🏃 Ejecutar la Aplicación

```bash
mvnw spring-boot:run
```

O en Windows:
```bash
mvnw.cmd spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## 🗄️ Acceso a H2 Console

URL: `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:tiendadb`
- Usuario: `sa`
- Contraseña: (dejar vacío)

## 👥 Usuarios Precargados

La aplicación carga automáticamente 5 usuarios:

| ID | Nombre | Correo | Contraseña |
|----|--------|--------|-----------|
| 1 | Juan Pérez | juan.perez@email.com | Qwerty123 |
| 2 | Ana Gómez | ana.gomez@email.com | Pass456 |
| 3 | Carlos Ruiz | carlos.ruiz@email.com | Segura789 |
| 4 | Sofía Martínez | sofia.martinez@email.com | Clave987 |
| 5 | Diego Fernández | diego.fernandez@email.com | Contra654 |

## 📊 Datos Iniciales

- 5 Usuarios
- 5 Categorías (Electrónica, Ropa, Hogar, Deportes, Libros)
- 50 Productos (10 por categoría)
- 50 Comentarios

## 🔐 Endpoints

### Públicos (sin autenticación)

#### 1. Login
```http
POST /auth/login
Content-Type: application/json

{
  "correoElectronico": "juan@email.com",
  "contrasena": "password123"
}
```

Respuesta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "tipo": "Bearer",
  "idUsuario": 1,
  "nombre": "Juan Pérez",
  "correoElectronico": "juan@email.com"
}
```

#### 2. Productos con Bajo Stock
```http
GET /productos/bajo-stock?x=15
```

#### 3. Comentarios desde una Fecha
```http
GET /comentarios/desde?fecha=2025-05-10
```

### Privados (requieren JWT)

Incluir el token en el header:
```
Authorization: Bearer {token}
```

#### 4. Crear Carrito
```http
POST /carrito
Authorization: Bearer {token}
```

#### 5. Agregar Producto al Carrito
```http
POST /carrito/{idCarrito}/agregar-producto/{idProducto}
Authorization: Bearer {token}
```

#### 6. Obtener Productos del Carrito
```http
GET /carrito/{idCarrito}/productos
Authorization: Bearer {token}
```

## 📦 Estructura del Proyecto

```
src/main/java/com/tienda/
├── config/              # Configuraciones (Security, DataLoader)
├── controller/          # Controladores REST
├── dto/                 # Data Transfer Objects
├── entity/              # Entidades JPA
├── repository/          # Repositorios JPA
├── security/
│   ├── jwt/            # Utilidades JWT y filtros
│   └── service/        # UserDetailsService
└── service/
    └── impl/           # Implementaciones de servicios
```

## 🧪 Probar con Postman

### Paso 1: Login
1. POST a `http://localhost:8080/auth/login`
2. Body (JSON):
```json
{
  "correoElectronico": "juan.perez@email.com",
  "contrasena": "Qwerty123"
}
```
3. Copiar el `token` de la respuesta

### Paso 2: Crear Carrito
1. POST a `http://localhost:8080/carrito`
2. Headers: `Authorization: Bearer {token}`
3. Copiar el `idCarrito` de la respuesta

### Paso 3: Agregar Producto
1. POST a `http://localhost:8080/carrito/1/agregar-producto/1`
2. Headers: `Authorization: Bearer {token}`

### Paso 4: Ver Productos del Carrito
1. GET a `http://localhost:8080/carrito/1/productos`
2. Headers: `Authorization: Bearer {token}`

## 🔒 Seguridad

- Las contraseñas se encriptan con BCrypt
- JWT con expiración de 24 horas
- Endpoints protegidos requieren autenticación
- Validación de permisos en operaciones de carrito

## 💡 Características Principales

- ✅ Autenticación JWT
- ✅ Gestión de productos con stock
- ✅ Sistema de comentarios
- ✅ Carrito de compras con cálculo automático de impuestos (19%)
- ✅ Validación de pertenencia de carrito al usuario
- ✅ Descuento automático de stock al agregar productos
- ✅ Datos de prueba precargados

## 📝 Notas

- La base de datos H2 es en memoria, los datos se pierden al reiniciar
- El impuesto aplicado es del 19% sobre el subtotal
- Al agregar un producto al carrito, el stock se reduce automáticamente
- Solo el propietario del carrito puede modificarlo

## 🐛 Solución de Problemas

Si tienes problemas al ejecutar:

1. Verifica que tienes Java 21 instalado: `java -version`
2. Limpia el proyecto: `mvnw clean install`
3. Verifica que el puerto 8080 esté disponible

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.
