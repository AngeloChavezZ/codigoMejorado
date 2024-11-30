package contenidosnew;

import static org.junit.Assert.*;
import org.junit.Test;

public class EspectaculoEnVivoTest {

    @Test
    public void testGetLugarYFecha() {
        EspectaculoEnVivo espectaculo = new EspectaculoEnVivo("Concierto Coldplay", 180, "Música", "Estadio Wembley", "2024-12-01");

        assertEquals("Estadio Wembley", espectaculo.getLugar());
        assertEquals("2024-12-01", espectaculo.getFecha());
    }

    @Test
    public void testMostrarDetalles() {
        EspectaculoEnVivo espectaculo = new EspectaculoEnVivo("Concierto Coldplay", 180, "Música", "Estadio Wembley", "2024-12-01");

        espectaculo.mostrarDetalles(); // Verifica que no lanza excepciones
    }
}
