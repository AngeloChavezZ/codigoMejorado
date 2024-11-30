package contenidosnew;

import java.util.ArrayList;
import java.util.List;

public class DocumentalInteractivo extends ContenidoAudiovisual {
    private String tema;
    private List<String> opcionesInteractivas;

    public DocumentalInteractivo(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.opcionesInteractivas = new ArrayList<>();
    }

    public void agregarOpcionInteractiva(String opcion) {
        opcionesInteractivas.add(opcion);
    }

    public void agregarOpcionesInteractivas(List<String> opciones) {
        this.opcionesInteractivas.addAll(opciones);
    }

    public String getTema() {
        return tema;
    }

    public List<String> getOpcionesInteractivas() {
        return opcionesInteractivas;
    }

    @Override
    public String convertirACSV() {
        return String.format("DocumentalInteractivo,%s,%d,%s,%s,%s",
                getTitulo(),
                getDuracionEnMinutos(),
                getGenero(),
                tema,
                String.join("|", opcionesInteractivas)
        );
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== Detalles del Documental Interactivo ===");
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + tema);
        System.out.println("Opciones Interactivas:");
        for (String opcion : opcionesInteractivas) {
            System.out.println("- " + opcion);
        }
    }
}
