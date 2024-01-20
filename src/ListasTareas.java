import java.util.ArrayList;
import java.util.List;

public class ListasTareas {

    Entrada leer = new Entrada();
    private Menus menu;
    private List<ListaTareas> listasTareas;
    private ListaTareas listaSeleccionada;
    private TasksManager manejadorTareas;

    public ListasTareas() {
        this.listasTareas = new ArrayList<>();
        this.menu = new Menus();
        this.manejadorTareas = new TasksManager(menu, this);
    }

    public void crearListaTareas() {
        String nombreLista;

        do{
            System.out.print("Ingresar nombre de nueva lista de tareas: ");
            nombreLista = leer.LeerString();

            if (nombreLista.trim().isEmpty()) {
                System.out.println("\nPor favor ingrese un nombre de tarea.");
            }
        } while (nombreLista.trim().isEmpty());

        ListaTareas nuevaListaTareas = new ListaTareas(nombreLista);
        listasTareas.add(nuevaListaTareas);
        System.out.printf("Nueva lista de tareas creada: %s\n", nombreLista);
    }

    public void verListasTareas() {
        System.out.println("Listas de tareas:");
        for (int i = 0; i < listasTareas.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, listasTareas.get(i).getNombre());
        }

        if (!listasTareas.isEmpty()) {
            System.out.print("Ingrese el número de la lista de tareas que desea seleccionar: ");
            int numeroSeleccionado = leer.LeerEntero();
            if (numeroSeleccionado >= 1 && numeroSeleccionado <= listasTareas.size()) {
                listaSeleccionada = listasTareas.get(numeroSeleccionado - 1);
                System.out.println("Lista seleccionada: " + listaSeleccionada.getNombre() + "\n");
            } else {
                System.out.println("Selección invalida, intente con otro número de tarea");
            }
        } else {
            System.out.println("No hay listas de tareas disponibles. Cree una nueva lista de tareas primero.");
        }
    }

    public void verTareasDeLista() {
        if (listaSeleccionada != null) {
            List<Tarea> tareas = listaSeleccionada.obtenerTareas();
            System.out.println("Las tareas en la lista de tareas son (" +
                    listaSeleccionada.getNombre() +
                    "):\n");

            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i).getNombre());
            }

            manejadorTareas.gestionarTareas();
        } else {
            System.out.println("Selección no válida");
        }
    }


    public void actualizarListaTareas() {
        if (listasTareas.isEmpty()) {
            System.out.println("No existen listas de tareas aún");
            return;
        }

        System.out.println("Listas de Tareas:");
        for (int i = 0; i < listasTareas.size(); i++) {
            System.out.println((i + 1) + "- " + listasTareas.get(i).getNombre());
        }

        System.out.print("Ingresar el número de la lista a actualizar: ");
        int numLista = leer.LeerEntero();

        if (numLista >= 1 && numLista <= listasTareas.size()) {
            ListaTareas listaSeleccionada = listasTareas.get(numLista - 1);

            listaSeleccionada.nombresTareas();

            System.out.print("Ingresar el número de la tarea a actualizar: ");
            int numeroTarea = leer.LeerEntero();

            if (numeroTarea >= 1 && numeroTarea <= listaSeleccionada.obtenerNumTareas()) {
                System.out.print("Ingresar nuevo nombre de tarea: ");
                String nuevoNombre = leer.LeerString();

                listaSeleccionada.actualizarNombreTarea(numeroTarea - 1, nuevoNombre);
            } else {
                System.out.println("Tarea no actualizada, número invalido");
            }
        } else {
            System.out.println("Lista no actualizada, número invalido");
        }
    }

    public ListaTareas getListaSeleccionada() {
        return this.listaSeleccionada;
    }

    public void eliminarListaTareas() {
        if (listaSeleccionada != null) {
            var nombreLista = listaSeleccionada.getNombre();
            listasTareas.remove(listaSeleccionada);
            listaSeleccionada = null;
            System.out.printf("La lista de tareas %s eliminada.%n", nombreLista);
        } else {
            System.out.println("No se seleccionó ninguna lista");
        }
    }
}
