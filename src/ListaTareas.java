import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ListaTareas {
    private String nombre;
    private final Date fecha;
    private List<Tarea> tareas;

    public ListaTareas(String nombre) {
        this.nombre = nombre;
        this.fecha = new Date();
        this.tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void eliminarTarea(int index) {
        if (index >= 0 && index < tareas.size()) {
            tareas.remove(index);
        } else {
            System.out.println("Tarea no eliminada. Indice inválido.");
        }
    }

    public List<Tarea> obtenerTareas() {
        return tareas;
    }

    public void marcarTareaComoRealizada(int numTarea) {
        if (numTarea >= 1 && numTarea <= tareas.size()) {
            Tarea tarea = tareas.get(numTarea - 1);
            tarea.marcarComoRealizada();

            System.out.println("La tarea " + tarea.getNombre() + "se ha marcado como realizada");
        } else {
            System.out.println("Tarea no marcada, número invalido");
        }
    }

    public int obtenerNumTareas() {
        return tareas.size();
    }

    public void nombresTareas() {
        if (tareas.isEmpty()) {
            System.out.println("Sin tareas");
        } else {
            System.out.println("Listando tareas de " + nombre + ":");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + "- " + tareas.get(i).getNombre());
            }
        }
    }

    public void actualizarNombreTarea(int index, String nuevoNombre) {
        if (index >= 0 && index < tareas.size()) {
            Tarea tarea = tareas.get(index);
            tarea.setNombre(nuevoNombre);
            System.out.println("Nuevo nombre de tarea: " + nuevoNombre);
        } else {
            System.out.println("Tarea no actualizada, número invalido");
        }
    }

    @Override
    public String toString() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Lista de Tareas: '").append(nombre).append("'\n");
        stringBuilder.append("Fecha de Creación: ").append(dateFormat.format(fecha)).append("\n");
        stringBuilder.append("Tareas:\n");

        if (tareas.isEmpty()) {
            stringBuilder.append("   No hay tareas en esta lista.\n");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                stringBuilder.append("   ").append(i + 1).append(". ").append(tareas.get(i).getNombre()).append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
