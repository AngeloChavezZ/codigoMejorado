package contenidosnew;

import java.util.ArrayList;
import java.util.List;

public class SerieDeTv extends ContenidoAudiovisual {
    private List<Temporada> temporadas;

    public SerieDeTv(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>();
    }

    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    @Override
    public String convertirACSV() {
        StringBuilder csv = new StringBuilder();
        for (Temporada temporada : temporadas) {
            csv.append(String.format("SerieDeTV,%s,%d,%s,%d,%s\n",
                    getTitulo(),
                    getDuracionEnMinutos(),
                    getGenero(),
                    temporada.getNumeroTemporada(),
                    String.join("|", temporada.getEpisodios())
            ));
        }
        return csv.toString().trim();
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== Detalles de la Serie de TV ===");
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración promedio por episodio: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas:");
        for (Temporada temporada : temporadas) {
            System.out.println("- Temporada " + temporada.getNumeroTemporada() + ":");
            System.out.println("  Episodios: " + String.join(", ", temporada.getEpisodios()));
        }
    }
}
