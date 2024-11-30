package contenidosnew;

public class EspectaculoEnVivo extends ContenidoAudiovisual {
    private String lugar;
    private String fecha;

    public EspectaculoEnVivo(String titulo, int duracionEnMinutos, String genero, String lugar, String fecha) {
        super(titulo, duracionEnMinutos, genero);
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String convertirACSV() {
        return String.format("EspectaculoEnVivo,%s,%d,%s,%s,%s",
                getTitulo(),
                getDuracionEnMinutos(),
                getGenero(),
                lugar,
                fecha
        );
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== Detalles del Espectáculo en Vivo ===");
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Lugar: " + lugar);
        System.out.println("Fecha: " + fecha);
    }
}
