package contenidosnew;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PeliculaTest {

    @Test
    public void testAgregarActores() {
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Christopher Nolan");
        pelicula.agregarActor(new Actor("Leonardo DiCaprio", 46, "Estados Unidos"));

        assertEquals(1, pelicula.getActores().size());
        assertEquals("Leonardo DiCaprio", pelicula.getActores().get(0).getNombre());
    }

    @Test
    public void testMostrarDetalles() {
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Christopher Nolan");
        pelicula.agregarActor(new Actor("Leonardo DiCaprio", 46, "Estados Unidos"));

        pelicula.mostrarDetalles(); // No lanza excepciones
    }
}
