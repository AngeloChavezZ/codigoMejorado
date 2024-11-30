package contenidosnew;

import static org.junit.Assert.*;
import org.junit.Test;

public class DocumentalTest {

    @Test
    public void testAgregarInvestigador() {
        Documental documental = new Documental("Our Planet", 60, "Naturaleza", "David Attenborough");
        Investigador investigador = new Investigador("Jane Goodall", "Primates", "Universidad de Cambridge");
        documental.agregarInvestigador(investigador);

        assertEquals(1, documental.getInvestigadores().size());
        assertEquals("Jane Goodall", documental.getInvestigadores().get(0).getNombre());
    }

    @Test
    public void testMostrarDetalles() {
        Documental documental = new Documental("Our Planet", 60, "Naturaleza", "David Attenborough");
        Investigador investigador = new Investigador("Jane Goodall", "Primates", "Universidad de Cambridge");
        documental.agregarInvestigador(investigador);

        documental.mostrarDetalles(); // Verifica que no lanza excepciones
    }
}
