package contenidosnew;

import java.util.*;
import java.io.File;


public class Main {
    public static void main(String[] args) {
    	System.out.println("Carpeta de trabajo actual: " + new File(".").getAbsolutePath());

        Scanner scanner = new Scanner(System.in);

        // Cargar contenidos desde el archivo CSV
        List<ContenidoAudiovisual> contenidos = ArchivoManager.cargarContenidosDesdeArchivo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(contenidos, vista);
        controlador.ejecutar(scanner);
        

        int opcion;

        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Listar Contenidos");
            System.out.println("2. Buscar Contenido");
            System.out.println("3. Agregar Contenido");
            System.out.println("4. Guardar y Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    listarContenidos(contenidos); // Llamar al método para listar contenidos
                    break;
                case 2:
                    buscarContenido(contenidos, scanner); // Buscar contenido por título
                    break;
                case 3:
                    agregarContenido(contenidos, scanner); // Agregar un nuevo contenido
                    break;
                case 4:
                    ArchivoManager.guardarContenidosEnArchivo(contenidos); // Guardar en el archivo
                    System.out.println("Cambios guardados. Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    // Método para listar los contenidos
    private static void listarContenidos(List<ContenidoAudiovisual> contenidos) {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenidos en el archivo.");
            return;
        }

        System.out.println("\n=== Listado de Contenidos ===");
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles(); // Llama al método mostrarDetalles() de cada contenido
            System.out.println(); // Línea en blanco para separar los contenidos
        }
    }

    // Método para buscar un contenido por título
    private static void buscarContenido(List<ContenidoAudiovisual> contenidos, Scanner scanner) {
        System.out.print("Introduce el título del contenido: ");
        String titulo = scanner.nextLine();

        for (ContenidoAudiovisual contenido : contenidos) {
            if (contenido.getTitulo().equalsIgnoreCase(titulo)) {
                contenido.mostrarDetalles();
                return;
            }
        }

        System.out.println("No se encontró un contenido con el título especificado.");
    }

    // Método para agregar un nuevo contenido
    private static void agregarContenido(List<ContenidoAudiovisual> contenidos, Scanner scanner) {
        System.out.println("\n=== Agregar Contenido ===");
        System.out.println("1. Película");
        System.out.println("2. Serie de TV");
        System.out.println("3. Documental");
        System.out.println("4. Documental Interactivo");
        System.out.println("5. Espectáculo en Vivo");
        System.out.print("Selecciona el tipo de contenido a agregar: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (tipo) {
            case 1: // Película
                System.out.print("Título: ");
                String titulo = scanner.nextLine();
                System.out.print("Duración en minutos: ");
                int duracion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.print("Género: ");
                String genero = scanner.nextLine();
                System.out.print("Director: ");
                String director = scanner.nextLine();
                System.out.print("Actores (separados por '|'): ");
                String actores = scanner.nextLine();

                Pelicula pelicula = new Pelicula(titulo, duracion, genero, director);
                pelicula.agregarActores(ArchivoManager.parsearActores(actores));
                contenidos.add(pelicula);

                System.out.println("Película agregada.");
                break;

            // Puedes agregar casos similares para otros tipos de contenido (Serie, Documental, etc.)
            default:
                System.out.println("Opción no válida. Intenta nuevamente.");
        }
    }
}

