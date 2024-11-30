package contenidosnew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pelicula extends ContenidoAudiovisual {
    private String director;
    private List<Actor> actores;

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String director) {
        super(titulo, duracionEnMinutos, genero);
        this.director = director;
        this.actores = new ArrayList<>();
    }

    public void agregarActor(Actor actor) {
        actores.add(actor);
    }

    public void agregarActores(List<Actor> actores) {
        this.actores.addAll(actores);
    }

    public String getDirector() {
        return director;
    }

    public List<Actor> getActores() {
        return actores;
    }

    @Override
    public String convertirACSV() {
        return String.format("Pelicula,%s,%d,%s,%s,%s",
                getTitulo(),
                getDuracionEnMinutos(),
                getGenero(),
                director,
                actores.stream().map(Actor::getNombre).collect(Collectors.joining("|"))
        );
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== Detalles de la Película ===");
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Director: " + director);
        System.out.println("Actores:");
        for (Actor actor : actores) {
            System.out.println("- " + actor.getNombre());
        }
    }
}
