public class TasksManager {
    private final ListasTareas listasTareas;
    private final Menus menu;

    public TasksManager(Menus menu, ListasTareas listasTareas) {
        this.menu = menu;
        this.listasTareas = listasTareas;
    }

    public void agregarNuevaTarea(String nombre) {
        ListaTareas listaSeleccionada = listasTareas.getListaSeleccionada();

        if (listaSeleccionada != null) {
            if (nombre != null && !nombre.trim().isEmpty()) {
                Tarea nuevaTarea = new Tarea(nombre);
                listaSeleccionada.agregarTarea(nuevaTarea);
                System.out.println("Nueva tarea agregada: " + nombre);
                listarTareas();
            } else {
                System.out.println("El nombre de la tarea no puede estar vacío.");
            }
        } else {
            System.out.println("No se seleccionó ninguna lista");
        }
    }

    public void eliminarTarea(int numeroTarea) {
        ListaTareas listaSeleccionada = listasTareas.getListaSeleccionada();
        int indiceTarea = numeroTarea - 1;

        if (listaSeleccionada != null && indiceTarea >= 0 && indiceTarea < listaSeleccionada.obtenerTareas().size()) {
            listaSeleccionada.eliminarTarea(indiceTarea);
            System.out.printf("Tarea %d eliminada.%n", numeroTarea);
            listarTareas();
        } else {
            System.out.println("Índice no válido. La tarea no se pudo eliminar.");
        }
    }

    public void marcarTareaComoRealizada(int numeroTarea) {
        ListaTareas listaSeleccionada = listasTareas.getListaSeleccionada();
        int indiceTarea = numeroTarea - 1;
        if (listaSeleccionada != null && indiceTarea >= 0 && indiceTarea < listaSeleccionada.obtenerTareas().size()) {
            Tarea tareaSeleccionada = listaSeleccionada.obtenerTareas().get(indiceTarea);
            if (!tareaSeleccionada.isRealizada()) {
                tareaSeleccionada.marcarComoRealizada();
                System.out.printf("Tarea %d marcada como realizada.%n", numeroTarea);
            } else {
                System.out.printf("La tarea %d ya ha sido marcada como realizada.%n", numeroTarea);
            }
            listarTareas();
        } else {
            System.out.println("No se seleccionó ninguna lista");
        }
    }

    private void listarTareas() {
        ListaTareas listaSeleccionada = listasTareas.getListaSeleccionada();

        if (listaSeleccionada != null) {

            for (int i = 0; i < listaSeleccionada.obtenerTareas().size(); i++) {
                Tarea tarea = listaSeleccionada.obtenerTareas().get(i);
                String estado = tarea.isRealizada() ? "Completada" : "Pendiente";
                System.out.println((i + 1) + "- " + tarea.getNombre() + " - Estado: " + estado);
            }
        } else {
            System.out.println("No se seleccionó ninguna lista");
        }
    }

    public void gestionarTareas() {
        if (listasTareas.getListaSeleccionada() == null) {
            System.out.println("No se seleccionó ninguna lista");
            return;
        }

        Entrada leer = new Entrada();
        int opcion;
        do {
            opcion = menu.MenuTareas();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresar nombre de nueva tarea: ");
                    String nombreTarea = leer.LeerString();

                    if (!nombreTarea.trim().isEmpty()) {
                        agregarNuevaTarea(nombreTarea);
                    } else {
                        System.out.println("Nombre de tarea vacío");
                    }
                    break;
                case 2:
                    System.out.print("Ingresar índice de tarea a eliminar: ");
                    int indiceEliminar = leer.LeerEntero();
                    leer.LeerString();
                    eliminarTarea(indiceEliminar);
                    break;
                case 3:
                    System.out.print("Ingresar índice de tarea a marcar como realizada: ");
                    int indiceMarcar = leer.LeerEntero();
                    leer.LeerString();
                    marcarTareaComoRealizada(indiceMarcar);
                    break;
                case 4:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intentar nuevamente");
                    leer.LeerString();
            }
        } while (opcion != 4);
    }
}
