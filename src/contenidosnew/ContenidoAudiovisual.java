package contenidosnew;

public abstract class ContenidoAudiovisual {
    private String titulo;
    private int duracionEnMinutos;
    private String genero;

    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public String getGenero() {
        return genero;
    }

    // Método abstracto para que cada clase concreta defina cómo exportarse al CSV
    public abstract String convertirACSV();

    // Método abstracto para mostrar los detalles del contenido
    public abstract void mostrarDetalles();
}
