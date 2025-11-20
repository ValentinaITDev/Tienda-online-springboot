package com.tienda.config;

import com.tienda.entity.*;
import com.tienda.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        // Crear usuarios
        List<Usuario> usuarios = crearUsuarios();
        
        // Crear categorías
        List<Categoria> categorias = crearCategorias();
        
        // Crear productos
        List<Producto> productos = crearProductos(categorias);
        
        // Crear comentarios
        crearComentarios(usuarios, productos);
        
        System.out.println("✅ Datos iniciales cargados correctamente");
    }
    
    private List<Usuario> crearUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        
        // Usuarios solicitados
        usuarios.add(new Usuario(null, "Juan Pérez", "juan.perez@email.com", 
            passwordEncoder.encode("Qwerty123"), "Carrera 45 #10-20", "Tarjeta de crédito"));
        usuarios.add(new Usuario(null, "Ana Gómez", "ana.gomez@email.com", 
            passwordEncoder.encode("Pass456"), "Calle 21 #35-50", "PayPal"));
        usuarios.add(new Usuario(null, "Carlos Ruiz", "carlos.ruiz@email.com", 
            passwordEncoder.encode("Segura789"), "Avenida Principal #100", "Transferencia bancaria"));
        usuarios.add(new Usuario(null, "Sofía Martínez", "sofia.martinez@email.com", 
            passwordEncoder.encode("Clave987"), "Calle 8 #20-30", "Efectivo"));
        usuarios.add(new Usuario(null, "Diego Fernández", "diego.fernandez@email.com", 
            passwordEncoder.encode("Contra654"), "Carrera 77 #40-60", "Tarjeta débito"));
        
        return usuarioRepository.saveAll(usuarios);
    }
    
    private List<Categoria> crearCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        
        categorias.add(new Categoria(null, "Electrónica", null));
        categorias.add(new Categoria(null, "Ropa", null));
        categorias.add(new Categoria(null, "Hogar", null));
        categorias.add(new Categoria(null, "Deportes", null));
        categorias.add(new Categoria(null, "Libros", null));
        
        return categoriaRepository.saveAll(categorias);
    }
    
    private List<Producto> crearProductos(List<Categoria> categorias) {
        List<Producto> productos = new ArrayList<>();
        
        // Productos EXACTOS según la rúbrica (50 productos)
        productos.add(new Producto(null, "Laptop", "Portátil con pantalla Full HD y SSD de 512GB", 89999.0, 10, categorias.get(0)));
        productos.add(new Producto(null, "Smartphone", "Teléfono con cámara de 108MP y carga rápida", 49950.0, 20, categorias.get(0)));
        productos.add(new Producto(null, "Tablet", "Dispositivo con pantalla táctil de 10 pulgadas", 29999.0, 15, categorias.get(0)));
        productos.add(new Producto(null, "Auriculares", "Audífonos inalámbricos con cancelación de ruido", 12999.0, 25, categorias.get(0)));
        productos.add(new Producto(null, "Teclado", "Teclado mecánico con iluminación RGB", 8999.0, 30, categorias.get(0)));
        productos.add(new Producto(null, "Mouse", "Ratón inalámbrico con sensor óptico de alta precisión", 5999.0, 50, categorias.get(0)));
        productos.add(new Producto(null, "Monitor", "Pantalla LED 4K de 27 pulgadas", 49900.0, 12, categorias.get(0)));
        productos.add(new Producto(null, "Impresora", "Láser multifuncional con Wi-Fi", 17999.0, 18, categorias.get(0)));
        productos.add(new Producto(null, "Cámara", "Cámara digital con lente profesional", 79999.0, 8, categorias.get(0)));
        productos.add(new Producto(null, "Smartwatch", "Reloj inteligente con GPS y monitoreo cardíaco", 19999.0, 22, categorias.get(0)));
        
        productos.add(new Producto(null, "Silla Gamer", "Silla ergonómica ajustable con soporte lumbar", 29999.0, 14, categorias.get(2)));
        productos.add(new Producto(null, "Microondas", "Horno microondas con múltiples funciones", 12999.0, 40, categorias.get(2)));
        productos.add(new Producto(null, "Refrigerador", "Frigorífico doble puerta con sistema No Frost", 119999.0, 5, categorias.get(2)));
        productos.add(new Producto(null, "Lavadora", "Lavadora automática con capacidad de 10kg", 59999.0, 7, categorias.get(2)));
        productos.add(new Producto(null, "Cafetera", "Cafetera express con vaporizador de leche", 14999.0, 35, categorias.get(2)));
        productos.add(new Producto(null, "Drone", "Drone con cámara 4K y estabilizador", 69999.0, 9, categorias.get(0)));
        productos.add(new Producto(null, "Bocina Bluetooth", "Altavoz portátil con sonido envolvente", 8999.0, 33, categorias.get(0)));
        productos.add(new Producto(null, "Videocámara", "Videocámara profesional con grabación en 4K", 99999.0, 6, categorias.get(0)));
        productos.add(new Producto(null, "TV LED", "Televisor inteligente de 55 pulgadas con HDR", 74999.0, 11, categorias.get(0)));
        productos.add(new Producto(null, "Batería Externa", "Batería de 20000mAh con carga rápida", 3999.0, 45, categorias.get(0)));
        
        productos.add(new Producto(null, "Disco Duro", "Disco duro externo de 2TB", 12999.0, 28, categorias.get(0)));
        productos.add(new Producto(null, "Memoria USB", "Pendrive de 128GB", 2999.0, 60, categorias.get(0)));
        productos.add(new Producto(null, "Router", "Router Wi-Fi 6 de alta velocidad", 19999.0, 16, categorias.get(0)));
        productos.add(new Producto(null, "Joystick", "Control inalámbrico para videojuegos", 7999.0, 20, categorias.get(0)));
        productos.add(new Producto(null, "Fuente de Poder", "Fuente de alimentación para PC de 750W", 8999.0, 17, categorias.get(0)));
        productos.add(new Producto(null, "SSD", "Unidad de almacenamiento SSD de 1TB", 14999.0, 32, categorias.get(0)));
        productos.add(new Producto(null, "Altavoces", "Par de bocinas estéreo con subwoofer", 13999.0, 23, categorias.get(0)));
        productos.add(new Producto(null, "Webcam", "Cámara web Full HD con micrófono integrado", 6999.0, 37, categorias.get(0)));
        productos.add(new Producto(null, "Procesador", "CPU Intel i7 de última generación", 34999.0, 9, categorias.get(0)));
        productos.add(new Producto(null, "Motherboard", "Placa base compatible con procesadores modernos", 19999.0, 13, categorias.get(0)));
        
        productos.add(new Producto(null, "Memoria RAM", "Módulo de RAM DDR4 de 16GB", 7999.0, 41, categorias.get(0)));
        productos.add(new Producto(null, "Fuente Solar", "Panel solar portátil con batería integrada", 24999.0, 4, categorias.get(0)));
        productos.add(new Producto(null, "Control Remoto", "Mando universal para TV y dispositivos", 2499.0, 50, categorias.get(0)));
        productos.add(new Producto(null, "Termostato", "Termostato digital programable", 9999.0, 22, categorias.get(2)));
        productos.add(new Producto(null, "Smart Lock", "Cerradura electrónica con huella digital", 19999.0, 6, categorias.get(2)));
        productos.add(new Producto(null, "Proyector", "Proyector LED con resolución Full HD", 29999.0, 12, categorias.get(0)));
        productos.add(new Producto(null, "Switch Ethernet", "Switch de red de 8 puertos", 5999.0, 38, categorias.get(0)));
        productos.add(new Producto(null, "Reloj Digital", "Reloj inteligente con pantalla AMOLED", 8999.0, 26, categorias.get(0)));
        productos.add(new Producto(null, "Luces LED", "Tiras LED RGB con control remoto", 3999.0, 55, categorias.get(2)));
        productos.add(new Producto(null, "Estabilizador", "Estabilizador de voltaje para dispositivos electrónicos", 15999.0, 10, categorias.get(0)));
        
        productos.add(new Producto(null, "Cargador Inalámbrico", "Base de carga inalámbrica rápida", 4999.0, 30, categorias.get(0)));
        productos.add(new Producto(null, "HDD Externo", "Disco duro portátil de 4TB", 17999.0, 15, categorias.get(0)));
        productos.add(new Producto(null, "Micrófono", "Micrófono profesional para grabación", 14999.0, 7, categorias.get(0)));
        productos.add(new Producto(null, "Altavoz Inteligente", "Asistente de voz con altavoz integrado", 12999.0, 20, categorias.get(0)));
        productos.add(new Producto(null, "Antena Wi-Fi", "Amplificador de señal inalámbrico", 7999.0, 33, categorias.get(0)));
        productos.add(new Producto(null, "Climatizador", "Aire acondicionado portátil con control remoto", 29999.0, 5, categorias.get(2)));
        productos.add(new Producto(null, "Raspberry Pi", "Kit de desarrollo con Raspberry Pi 4", 12999.0, 19, categorias.get(0)));
        productos.add(new Producto(null, "Capturadora", "Placa de captura de video en alta resolución", 19999.0, 8, categorias.get(0)));
        productos.add(new Producto(null, "Smart Plug", "Enchufe inteligente compatible con asistentes virtuales", 3999.0, 42, categorias.get(2)));
        productos.add(new Producto(null, "Timbre Inteligente", "Timbre con cámara y conexión a Wi-Fi", 14999.0, 10, categorias.get(2)));
        
        return productoRepository.saveAll(productos);
    }
    
    private void crearComentarios(List<Usuario> usuarios, List<Producto> productos) {
        List<Comentario> comentarios = new ArrayList<>();
        
        // Comentarios EXACTOS según la rúbrica (50 comentarios)
        comentarios.add(new Comentario(null, productos.get(0), usuarios.get(0), "Excelente rendimiento; muy rápida. ¡Me encanta!", LocalDate.of(2025, 5, 1)));
        comentarios.add(new Comentario(null, productos.get(1), usuarios.get(1), "Buena cámara pero la batería dura poco.", LocalDate.of(2025, 5, 3)));
        comentarios.add(new Comentario(null, productos.get(2), usuarios.get(2), "No me gustó; pantalla de baja calidad.", LocalDate.of(2025, 5, 5)));
        comentarios.add(new Comentario(null, productos.get(3), usuarios.get(3), "Sonido aceptable pero el material parece frágil.", LocalDate.of(2025, 5, 6)));
        comentarios.add(new Comentario(null, productos.get(4), usuarios.get(4), "Muy buen teclado mecánico; excelente respuesta.", LocalDate.of(2025, 5, 8)));
        comentarios.add(new Comentario(null, productos.get(5), usuarios.get(1), "El sensor no es tan preciso como esperaba.", LocalDate.of(2025, 5, 10)));
        comentarios.add(new Comentario(null, productos.get(6), usuarios.get(2), "Colores vibrantes y buena resolución. Muy satisfecho.", LocalDate.of(2025, 5, 12)));
        comentarios.add(new Comentario(null, productos.get(7), usuarios.get(0), "Tarda mucho en imprimir; no me convence.", LocalDate.of(2025, 5, 13)));
        comentarios.add(new Comentario(null, productos.get(8), usuarios.get(3), "Increíble calidad de imagen; fotos súper nítidas.", LocalDate.of(2025, 5, 15)));
        comentarios.add(new Comentario(null, productos.get(9), usuarios.get(4), "Buena batería; pero la pantalla no es muy brillante.", LocalDate.of(2025, 5, 18)));
        
        comentarios.add(new Comentario(null, productos.get(10), usuarios.get(0), "Comodidad espectacular; perfecto para largas sesiones de juego.", LocalDate.of(2025, 5, 20)));
        comentarios.add(new Comentario(null, productos.get(11), usuarios.get(1), "Calienta bien pero hace mucho ruido.", LocalDate.of(2025, 5, 22)));
        comentarios.add(new Comentario(null, productos.get(12), usuarios.get(2), "Espacioso y enfría rápido; muy recomendado.", LocalDate.of(2025, 5, 24)));
        comentarios.add(new Comentario(null, productos.get(13), usuarios.get(3), "Lava bien pero el ciclo es muy largo.", LocalDate.of(2025, 5, 26)));
        comentarios.add(new Comentario(null, productos.get(14), usuarios.get(4), "Hace café delicioso; fácil de usar.", LocalDate.of(2025, 5, 28)));
        comentarios.add(new Comentario(null, productos.get(15), usuarios.get(0), "Muy divertido pero la batería dura poco.", LocalDate.of(2025, 5, 30)));
        comentarios.add(new Comentario(null, productos.get(16), usuarios.get(1), "Sonido potente y buena conexión Bluetooth.", LocalDate.of(2025, 6, 1)));
        comentarios.add(new Comentario(null, productos.get(17), usuarios.get(2), "Perfecta para grabaciones profesionales.", LocalDate.of(2025, 6, 3)));
        comentarios.add(new Comentario(null, productos.get(18), usuarios.get(3), "Imagen excelente pero el sonido podría mejorar.", LocalDate.of(2025, 6, 5)));
        comentarios.add(new Comentario(null, productos.get(19), usuarios.get(4), "Carga bien pero es un poco pesada.", LocalDate.of(2025, 6, 7)));
        
        comentarios.add(new Comentario(null, productos.get(20), usuarios.get(0), "Gran capacidad de almacenamiento; funciona rápido.", LocalDate.of(2025, 6, 9)));
        comentarios.add(new Comentario(null, productos.get(21), usuarios.get(1), "Buen tamaño pero la velocidad de transferencia es baja.", LocalDate.of(2025, 6, 11)));
        comentarios.add(new Comentario(null, productos.get(22), usuarios.get(2), "Señal potente; cubre toda la casa.", LocalDate.of(2025, 6, 13)));
        comentarios.add(new Comentario(null, productos.get(23), usuarios.get(3), "Comodo y resistente; ideal para gaming.", LocalDate.of(2025, 6, 15)));
        comentarios.add(new Comentario(null, productos.get(24), usuarios.get(4), "Funciona bien pero los cables son muy cortos.", LocalDate.of(2025, 6, 17)));
        comentarios.add(new Comentario(null, productos.get(25), usuarios.get(0), "Velocidad increíble; mi PC va mucho más rápido ahora.", LocalDate.of(2025, 6, 19)));
        comentarios.add(new Comentario(null, productos.get(26), usuarios.get(1), "Sonido envolvente; muy buena compra.", LocalDate.of(2025, 6, 21)));
        comentarios.add(new Comentario(null, productos.get(27), usuarios.get(2), "Imagen clara pero el micrófono es deficiente.", LocalDate.of(2025, 6, 23)));
        comentarios.add(new Comentario(null, productos.get(28), usuarios.get(3), "Rendimiento impecable; ideal para gaming y diseño.", LocalDate.of(2025, 6, 25)));
        comentarios.add(new Comentario(null, productos.get(29), usuarios.get(4), "Buenas prestaciones pero la instalación fue complicada.", LocalDate.of(2025, 6, 27)));
        
        comentarios.add(new Comentario(null, productos.get(30), usuarios.get(0), "Expande muy bien el rendimiento del sistema.", LocalDate.of(2025, 6, 29)));
        comentarios.add(new Comentario(null, productos.get(31), usuarios.get(1), "Energía confiable pero la batería es pequeña.", LocalDate.of(2025, 7, 1)));
        comentarios.add(new Comentario(null, productos.get(32), usuarios.get(2), "Fácil de usar; reconoce muchos dispositivos.", LocalDate.of(2025, 7, 3)));
        comentarios.add(new Comentario(null, productos.get(33), usuarios.get(3), "Regula bien la temperatura; intuitivo de usar.", LocalDate.of(2025, 7, 5)));
        comentarios.add(new Comentario(null, productos.get(34), usuarios.get(4), "Seguridad y tecnología en un solo dispositivo.", LocalDate.of(2025, 7, 7)));
        comentarios.add(new Comentario(null, productos.get(35), usuarios.get(0), "Imagen nítida pero requiere una sala oscura.", LocalDate.of(2025, 7, 9)));
        comentarios.add(new Comentario(null, productos.get(36), usuarios.get(1), "Buena velocidad de conexión; estable.", LocalDate.of(2025, 7, 11)));
        comentarios.add(new Comentario(null, productos.get(37), usuarios.get(2), "Pantalla atractiva pero la batería dura poco.", LocalDate.of(2025, 7, 13)));
        comentarios.add(new Comentario(null, productos.get(38), usuarios.get(3), "Buenas opciones de colores; buen diseño.", LocalDate.of(2025, 7, 15)));
        comentarios.add(new Comentario(null, productos.get(39), usuarios.get(4), "Protege bien contra variaciones de voltaje.", LocalDate.of(2025, 7, 17)));
        
        comentarios.add(new Comentario(null, productos.get(40), usuarios.get(0), "Carga rápido pero requiere posicionamiento preciso.", LocalDate.of(2025, 7, 19)));
        comentarios.add(new Comentario(null, productos.get(41), usuarios.get(1), "Mucho espacio; resistente y confiable.", LocalDate.of(2025, 7, 21)));
        comentarios.add(new Comentario(null, productos.get(42), usuarios.get(2), "Calidad de sonido profesional; ideal para podcast.", LocalDate.of(2025, 7, 23)));
        comentarios.add(new Comentario(null, productos.get(43), usuarios.get(3), "Responde bien a comandos de voz; útil en casa.", LocalDate.of(2025, 7, 25)));
        comentarios.add(new Comentario(null, productos.get(44), usuarios.get(4), "Amplifica bien la señal pero el rango es limitado.", LocalDate.of(2025, 7, 27)));
        comentarios.add(new Comentario(null, productos.get(45), usuarios.get(0), "Enfría rápido pero es algo ruidoso.", LocalDate.of(2025, 7, 29)));
        comentarios.add(new Comentario(null, productos.get(46), usuarios.get(1), "Perfecto para proyectos electrónicos y programación.", LocalDate.of(2025, 7, 31)));
        comentarios.add(new Comentario(null, productos.get(47), usuarios.get(2), "Ideal para streaming y grabaciones en alta calidad.", LocalDate.of(2025, 8, 2)));
        comentarios.add(new Comentario(null, productos.get(48), usuarios.get(3), "Muy práctico; fácil de conectar y configurar.", LocalDate.of(2025, 8, 4)));
        comentarios.add(new Comentario(null, productos.get(49), usuarios.get(4), "Buena cámara; útil para seguridad.", LocalDate.of(2025, 8, 6)));
        
        comentarioRepository.saveAll(comentarios);
    }
}
