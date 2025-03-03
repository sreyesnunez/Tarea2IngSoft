# 🚀 Proyecto HolaSpring6CV3

Este es un proyecto de ejemplo desarrollado con Spring Boot, que muestra cómo configurar y ejecutar una aplicación web básica con soporte para Docker y pruebas en Postman.

## 📌 Requisitos previos

Antes de ejecutar este proyecto, asegúrate de tener instalado en tu computadora:

- **Java Development Kit (JDK) 21**  
  - Verifica con el comando:  
    ```sh
    java -version
    ```
- **Maven**  
  - Verifica con el comando:  
    ```sh
    mvn -version
    ```
- **Docker y Docker Compose**  
  - Verifica con el comando:  
    ```sh
    docker --version
    docker-compose --version
    ```

## 🛠️ Instalación y ejecución manual

Para ejecutar el proyecto, sigue estos pasos:

1. **Clonar el repositorio**  
   ```sh
   git clone https://github.com/tu-usuario/HolaSpring6CV3.git
   cd HolaSpring6CV3

2. **Compilar el proyecto**
        mvn clean package

3. **Ejecutar la Aplicacion**
        mvn spring-boot:run

4. **Abrir en el Navegador**
        http://localhost:8080/

## 🛠️ Ejecución con Docker

Para ejecutar el proyecto en contenedores Docker, sigue estos pasos:

1. **Construir y ejecutar los contenedores**  
   ```sh
        docker-compose up --build

2. **Verifica que los contenedores están corriendo**
        docker ps

3. **Abrir aplicación en el Navegador**
        http://localhost:8080/

4. **Para detener los contenedores**
        docker-compose down

## 🔮 Pruebas con Postman

Las pruebas de los endpoints de la API han sido documentadas y pueden ser ejecutadas usando Postman.

## 📝 Importar colección de Postman

Para importar la colección de pruebas en Postman:

1. **Abre Postman**

2. **Ve a File > Import**

3. **Selecciona el archivo HolaSpring6CV3.postman_collection.json (proporcionado en este repositorio)**

4. **Ejecuta las pruebas en la pestaña Collections**

## 🔎 Endpoints disponibles

Algunos de los endpoints principales que puedes probar:

**GET /api/usuarios → Obtiene la lista de usuarios**

**POST /api/usuarios → Crea un nuevo usuario (requiere body JSON)**

**GET /api/roles → Lista de roles disponibles**

**POST /api/login → Autenticación de usuario**

