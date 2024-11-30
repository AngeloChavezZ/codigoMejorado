package contenidosnew;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class DocumentalInteractivoTest {

    @Test
    public void testAgregarOpcionesInteractivas() {
        DocumentalInteractivo docInteractivo = new DocumentalInteractivo("Vida Salvaje Interactiva", 85, "Documental", "Fauna del Mundo");
        docInteractivo.agregarOpcionesInteractivas(Arrays.asList("Explorar hábitats", "Interacción con animales"));

        assertEquals(2, docInteractivo.getOpcionesInteractivas().size());
        assertEquals("Explorar hábitats", docInteractivo.getOpcionesInteractivas().get(0));
    }

    @Test
    public void testMostrarDetalles() {
        DocumentalInteractivo docInteractivo = new DocumentalInteractivo("Vida Salvaje Interactiva", 85, "Documental", "Fauna del Mundo");
        docInteractivo.agregarOpcionesInteractivas(Arrays.asList("Explorar hábitats", "Interacción con animales"));

        docInteractivo.mostrarDetalles(); // Verifica que no lanza excepciones
    }
}
