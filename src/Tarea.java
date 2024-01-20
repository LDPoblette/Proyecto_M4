import java.util.Date;

public class Tarea {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private final Date fechaCreacion;
    private Date fechaExpiracion;
    private boolean tareaCompletada;

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = new Date();
        this.tareaCompletada = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean isRealizada() {
        return tareaCompletada;
    }

    public void marcarComoRealizada() {
        this.tareaCompletada = true;
    }

    @Override
    public String toString() {
        return String.format("Tarea: %s\n Fecha de creación: %s\n Fecha de expiración: %s\n Estatus: %s",
                nombre,
                fechaCreacion,
                fechaExpiracion != null ? fechaExpiracion.toString() : "N/A",
                tareaCompletada ? "Realizada" : "Pendiente");
    }
}
