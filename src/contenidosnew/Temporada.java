package contenidosnew;

import java.util.List;

public class Temporada {
    private int numeroTemporada;
    private List<String> episodios;

    public Temporada(int numeroTemporada, List<String> episodios) {
        this.numeroTemporada = numeroTemporada;
        this.episodios = episodios;
    }

    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public List<String> getEpisodios() {
        return episodios;
    }

    public void mostrarDetalles() {
        System.out.println("- Temporada " + numeroTemporada + ":");
        for (String episodio : episodios) {
            System.out.println("  - " + episodio);
        }
    }
}
