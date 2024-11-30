package contenidosnew;

import java.util.ArrayList;
import java.util.List;

public class Documental extends ContenidoAudiovisual {
    private String director;
    private List<Investigador> investigadores;

    public Documental(String titulo, int duracionEnMinutos, String genero, String director) {
        super(titulo, duracionEnMinutos, genero);
        this.director = director;
        this.investigadores = new ArrayList<>();
    }

    public void agregarInvestigador(Investigador investigador) {
        investigadores.add(investigador);
    }

    public void agregarInvestigadores(List<Investigador> listaInvestigadores) {
        this.investigadores.addAll(listaInvestigadores);
    }

    public String getDirector() {
        return director;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    @Override
    public String convertirACSV() {
        return String.format("Documental,%s,%d,%s,%s,%s",
                getTitulo(),
                getDuracionEnMinutos(),
                getGenero(),
                director,
                investigadores.stream()
                        .map(i -> String.join("\\", i.getNombre(), i.getEspecializacion(), i.getAfiliacion()))
                        .reduce((a, b) -> a + "|" + b)
                        .orElse("")
        );
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== Detalles del Documental ===");
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Director: " + director);
        System.out.println("Investigadores:");
        for (Investigador investigador : investigadores) {
            System.out.println("- " + investigador.getNombre() + " (" + investigador.getEspecializacion() + ", " + investigador.getAfiliacion() + ")");
        }
    }
}
