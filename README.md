# Contenidos Audiovisuales

Este proyecto implementa un sistema de gestión de contenidos audiovisuales utilizando el patrón MVC (Modelo-Vista-Controlador). Permite gestionar películas, series de TV, documentales y espectáculos en vivo, así como realizar pruebas unitarias para garantizar la funcionalidad del sistema.

## Características

1. **Gestión de Contenidos**: 
   - Soporte para diferentes tipos de contenidos (Películas, Series, Documentales, Espectáculos en Vivo).
   - Carga y almacenamiento de contenidos desde un archivo CSV.
   - Visualización de detalles de los contenidos.

2. **Patrón MVC**:
   - Separación clara de las responsabilidades en las capas de modelo, vista y controlador.

3. **Pruebas Unitarias**:
   - Implementación de pruebas con JUnit para garantizar la calidad del código.

4. **Cobertura de Código**:
   - Casos límite y excepcionales incluidos en las pruebas.

---

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes y archivos principales:

- **Modelo (`src/`)**:
  - `ContenidoAudiovisual.java`: Clase base para los contenidos.
  - `Pelicula.java`, `SerieDeTV.java`, `Documental.java`, `EspectaculoEnVivo.java`: Clases específicas para cada tipo de contenido.

- **Controlador**:
  - `Controlador.java`: Lógica principal que conecta la vista con el modelo.

- **Vista**:
  - `Vista.java`: Interfaz de usuario en consola para interactuar con el sistema.

- **Pruebas Unitarias (`src/test/`)**:
  - `PeliculaTest.java`, `SerieDeTVTest.java`, etc.: Pruebas unitarias para cada clase.

---

## Instalación y Ejecución

### Requisitos Previos

1. Tener instalado [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (versión 11 o superior).
2. Tener configurado un entorno de desarrollo como [Eclipse](https://www.eclipse.org/) o [IntelliJ IDEA](https://www.jetbrains.com/idea/).

### Clonar el Proyecto

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/AngeloChavezZ/codigoMejorado.git
