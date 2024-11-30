package contenidosnew;

import java.util.List;

public class Vista {
    public void mostrarMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Listar Contenidos");
        System.out.println("2. Buscar Contenido");
        System.out.println("3. Agregar Contenido");
        System.out.println("4. Guardar y Salir");
        System.out.print("Selecciona una opción: ");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarContenidos(List<ContenidoAudiovisual> contenidos) {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenidos en el archivo.");
            return;
        }

        System.out.println("\n=== Listado de Contenidos ===");
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
            System.out.println(); // Línea en blanco para separar contenidos
        }
    }
}
