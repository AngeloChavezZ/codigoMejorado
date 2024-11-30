package contenidosnew;

public class Investigador {
    private String nombre;
    private String especializacion;
    private String afiliacion;

    public Investigador(String nombre, String especializacion, String afiliacion) {
        this.nombre = nombre;
        this.especializacion = especializacion;
        this.afiliacion = afiliacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public String getAfiliacion() {
        return afiliacion;
    }
}
