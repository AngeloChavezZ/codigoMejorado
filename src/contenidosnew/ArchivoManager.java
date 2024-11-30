package contenidosnew;

import java.io.*;
import java.util.*;

public class ArchivoManager {
    private static final String ARCHIVO_CSV = "C:\\Users\\Jordan Kaleth\\eclipse-workspace\\contenidosnew\\src\\contenidos.csv";

    // Guardar los contenidos en un archivo CSV
    public static void guardarContenidosEnArchivo(List<ContenidoAudiovisual> contenidos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CSV))) {
            for (ContenidoAudiovisual contenido : contenidos) {
                writer.write(contenido.convertirACSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los contenidos en el archivo: " + e.getMessage());
        }
    }

    // Cargar contenidos desde un archivo CSV
    public static List<ContenidoAudiovisual> cargarContenidosDesdeArchivo() {
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        File archivo = new File(ARCHIVO_CSV);

        System.out.println("Ruta absoluta esperada del archivo: " + archivo.getAbsolutePath());

        if (!archivo.exists()) {
            System.out.println("Error: El archivo contenidos.csv no existe en la ruta: " + archivo.getAbsolutePath());
            return contenidos;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CSV))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("Línea leída: " + linea); // Depuración
                ContenidoAudiovisual contenido = crearContenidoDesdeLinea(linea);
                if (contenido != null) {
                    System.out.println("Contenido agregado: " + contenido.getTitulo());
                    contenidos.add(contenido);
                } else {
                    System.out.println("Error al procesar la línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo contenidos.csv: " + e.getMessage());
        }
        return contenidos;
    }

    // Crear un contenido a partir de una línea del archivo CSV
    private static ContenidoAudiovisual crearContenidoDesdeLinea(String linea) {
        String[] datos = linea.split(",", -1);
        if (datos.length < 5) {
            System.err.println("Línea inválida: " + linea);
            return null;
        }

        switch (datos[0]) {
            case "Pelicula":
                Pelicula pelicula = new Pelicula(datos[1], Integer.parseInt(datos[2]), datos[3], datos[4]);
                pelicula.agregarActores(parsearActores(datos[5]));
                return pelicula;
            case "SerieDeTV":
                SerieDeTv serie = new SerieDeTv(datos[1], Integer.parseInt(datos[2]), datos[3]);
                String[] episodios = datos[5].split("\\|");
                serie.agregarTemporada(new Temporada(1, Arrays.asList(episodios))); // Procesa los episodios como Temporada 1
                return serie;
            case "Documental":
                Documental documental = new Documental(datos[1], Integer.parseInt(datos[2]), datos[3], datos[4]);
                documental.agregarInvestigadores(parsearInvestigadores(datos[5]));
                return documental;
            case "DocumentalInteractivo":
                DocumentalInteractivo docInteractivo = new DocumentalInteractivo(datos[1], Integer.parseInt(datos[2]), datos[3], datos[4]);
                docInteractivo.agregarOpcionesInteractivas(Arrays.asList(datos[5].split("\\|")));
                return docInteractivo;
            case "EspectaculoEnVivo":
                return new EspectaculoEnVivo(datos[1], Integer.parseInt(datos[2]), datos[3], datos[4], datos[5]);
            default:
                System.err.println("Tipo de contenido desconocido: " + datos[0]);
                return null;
        }
    }

    // Métodos auxiliares para parsear datos
    public static List<Actor> parsearActores(String datosActores) {
        if (datosActores == null || datosActores.isEmpty()) {
            return new ArrayList<>();
        }
        List<Actor> actores = new ArrayList<>();
        String[] actoresDatos = datosActores.split("\\|");
        for (String actor : actoresDatos) {
            actores.add(new Actor(actor, 0, "Desconocido")); // Puedes ajustar según tu modelo
        }
        return actores;
    }

    private static List<Investigador> parsearInvestigadores(String datosInvestigadores) {
        if (datosInvestigadores == null || datosInvestigadores.isEmpty()) {
            return new ArrayList<>();
        }
        List<Investigador> investigadores = new ArrayList<>();
        String[] investigadoresDatos = datosInvestigadores.split("\\|");
        for (String investigador : investigadoresDatos) {
            String[] detalle = investigador.split("\\\\");
            if (detalle.length == 3) {
                investigadores.add(new Investigador(detalle[0], detalle[1], detalle[2]));
            }
        }
        return investigadores;
    }
}

