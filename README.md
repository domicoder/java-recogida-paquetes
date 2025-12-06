# RePAQ - Sistema de Recogida de Paquetes

Sistema de gestión de recogida de paquetes desarrollado en **Java Swing**. Permite llevar el control de paquetes de clientes, gestionar entregas y generar reportes administrativos.

---

## Descripcion

RePAQ es una aplicación de escritorio que facilita la gestión de paquetes en un centro de distribución. El sistema cuenta con tres tipos de usuarios:

-   **Administrador**: Gestiona clientes, receptores, paquetes y genera reportes estadísticos.
-   **Receptor**: Consulta paquetes disponibles, busca clientes y registra entregas.
-   **Cliente**: Visualiza su perfil y el estado de sus paquetes.

---

## Funcionalidades

### Administrador

-   Agregar y gestionar clientes
-   Agregar y gestionar receptores
-   Registrar nuevos paquetes
-   Buscar clientes por nombre o apellido
-   Buscar paquetes por estado (disponible, entregado)
-   Generar correos de notificación a clientes
-   Visualizar reportes estadísticos:
    -   Recogidas por día, semana y mes
    -   Porcentaje de paquetes entregados vs pendientes
    -   Distribución de clientes por género
    -   Día de la semana con mayor cantidad de recogidas

### Receptor

-   Consultar paquetes disponibles para el día
-   Marcar paquetes como entregados
-   Buscar clientes

### Cliente

-   Ver perfil personal
-   Consultar estado de sus paquetes

---

## Requisitos del Sistema

-   **Java JDK 8** o superior
-   **MySQL 5.7** o superior
-   **NetBeans IDE** (recomendado para desarrollo)

### Dependencias

-   MySQL Connector/J (driver JDBC)
-   Apache Commons Codec (para encriptación MD5)
-   JavaMail API (para envío de correos)

---

## Instalacion

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/java-recogida-paquetes.git
cd java-recogida-paquetes
```

### 2. Configurar la base de datos

Crear la base de datos MySQL llamada `recogidapaquetes` con las tablas necesarias:

-   `administrador`
-   `cliente`
-   `receptor`
-   `paquete`

### 3. Configurar credenciales

Copiar el archivo de plantilla de configuración:

```bash
cp config.properties.template src/config.properties
```

Editar `src/config.properties` con tus credenciales:

```properties
# Configuracion de Base de Datos
db.url=jdbc:mysql://localhost:3306/recogidapaquetes
db.user=tu_usuario
db.password=tu_contraseña

# Configuracion de Correo (Gmail)
smtp.host=smtp.gmail.com
smtp.port=587
smtp.starttls.enable=true
smtp.auth=true
smtp.user=tu_correo@gmail.com
smtp.password=tu_app_password
```

**Nota sobre Gmail**: Para usar Gmail como servidor SMTP, debes:

1. Activar la verificación en dos pasos en tu cuenta de Google
2. Generar una contraseña de aplicación en: https://myaccount.google.com/apppasswords
3. Usar esa contraseña de aplicación en el archivo de configuración

### 4. Compilar y ejecutar

Abrir el proyecto en NetBeans y ejecutar, o compilar desde terminal:

```bash
ant compile
ant run
```

---

## Configuracion mediante Variables de Entorno

Alternativamente, puedes configurar las credenciales usando variables de entorno (tienen prioridad sobre el archivo de propiedades):

```bash
export REPAQ_DB_URL="jdbc:mysql://localhost:3306/recogidapaquetes"
export REPAQ_DB_USER="usuario"
export REPAQ_DB_PASSWORD="contraseña"
export REPAQ_SMTP_USER="correo@gmail.com"
export REPAQ_SMTP_PASSWORD="app_password"
```

---

## Estructura del Proyecto

```
java-recogida-paquetes/
├── src/
│   └── com/recogidapaquete/
│       ├── base/           # Clases base y patrones de diseño
│       ├── BD/             # Capa de acceso a datos (MySQL)
│       ├── config/         # Gestión de configuración
│       ├── images/         # Recursos gráficos
│       └── interfaces/     # Interfaces gráficas (Swing)
├── config.properties.template  # Plantilla de configuración
├── build.xml               # Script de construcción Ant
└── README.md
```

---

## Patrones de Diseño Implementados

-   **Singleton**: Conexión a base de datos (`ConexionMySQL`)
-   **Observer**: Notificaciones por correo cuando hay paquetes disponibles
-   **Mediator**: Comunicación entre componentes de la aplicación
-   **State**: Gestión de estados de paquetes (Disponible, Entregado)

---

## Seguridad

-   Las contraseñas de usuarios se almacenan encriptadas con MD5 en la base de datos
-   Las credenciales sensibles (base de datos, correo) se cargan desde un archivo de configuración externo
-   El archivo `config.properties` está excluido del control de versiones

---

## Licencia

Este proyecto fue desarrollado con fines educativos.
