package contenidosnew;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class SerieDeTVTest {

    @Test
    public void testAgregarTemporada() {
        SerieDeTv serie = new SerieDeTv("Stranger Things", 50, "Ciencia Ficción");
        Temporada temporada = new Temporada(1, Arrays.asList("Episodio 1", "Episodio 2"));
        serie.agregarTemporada(temporada);

        assertEquals(1, serie.getTemporadas().size());
        assertEquals(1, serie.getTemporadas().get(0).getNumeroTemporada());
        assertEquals("Episodio 1", serie.getTemporadas().get(0).getEpisodios().get(0));
    }

    @Test
    public void testMostrarDetalles() {
        SerieDeTv serie = new SerieDeTv("Stranger Things", 50, "Ciencia Ficción");
        Temporada temporada = new Temporada(1, Arrays.asList("Episodio 1", "Episodio 2"));
        serie.agregarTemporada(temporada);

        serie.mostrarDetalles(); // Verifica que no lanza excepciones
    }
}
