package contenidosnew;

import java.util.List;
import java.util.Scanner;

public class Controlador {
    private final List<ContenidoAudiovisual> contenidos;
    private final Vista vista;

    public Controlador(List<ContenidoAudiovisual> contenidos, Vista vista) {
        this.contenidos = contenidos;
        this.vista = vista;
    }

    public void ejecutar(Scanner scanner) {
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    listarContenidos();
                    break;
                case 2:
                    buscarContenido(scanner);
                    break;
                case 3:
                    agregarContenido(scanner);
                    break;
                case 4:
                    guardarContenidos();
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 4);
    }

    private void listarContenidos() {
        vista.mostrarContenidos(contenidos);
    }

    private void buscarContenido(Scanner scanner) {
        vista.mostrarMensaje("Introduce el título del contenido: ");
        String titulo = scanner.nextLine();

        for (ContenidoAudiovisual contenido : contenidos) {
            if (contenido.getTitulo().equalsIgnoreCase(titulo)) {
                contenido.mostrarDetalles();
                return;
            }
        }

        vista.mostrarMensaje("No se encontró un contenido con el título especificado.");
    }

    private void agregarContenido(Scanner scanner) {
        vista.mostrarMensaje("\n=== Agregar Contenido ===");
        vista.mostrarMensaje("1. Película");
        vista.mostrarMensaje("2. Serie de TV");
        vista.mostrarMensaje("3. Documental");
        vista.mostrarMensaje("4. Documental Interactivo");
        vista.mostrarMensaje("5. Espectáculo en Vivo");
        vista.mostrarMensaje("Selecciona el tipo de contenido a agregar: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (tipo) {
            case 1: // Película
                vista.mostrarMensaje("Título: ");
                String titulo = scanner.nextLine();
                vista.mostrarMensaje("Duración en minutos: ");
                int duracion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                vista.mostrarMensaje("Género: ");
                String genero = scanner.nextLine();
                vista.mostrarMensaje("Director: ");
                String director = scanner.nextLine();
                vista.mostrarMensaje("Actores (separados por '|'): ");
                String actores = scanner.nextLine();

                Pelicula pelicula = new Pelicula(titulo, duracion, genero, director);
                pelicula.agregarActores(ArchivoManager.parsearActores(actores));
                contenidos.add(pelicula);

                vista.mostrarMensaje("Película agregada.");
                break;

            default:
                vista.mostrarMensaje("Opción no válida. Intenta nuevamente.");
        }
    }

    private void guardarContenidos() {
        ArchivoManager.guardarContenidosEnArchivo(contenidos);
        vista.mostrarMensaje("Cambios guardados.");
    }
}
