public class Menus {

    Entrada leer = new Entrada();

    public int MenuPrincipal(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("1.- Crear nueva lista de tareas");
        System.out.println("2.- Ver listas de tareas");
        System.out.println("3.- Ver tareas de lista");
        System.out.println("4.- Actualizar lista de tareas");
        System.out.println("5.- Eliminar lista de tareas");
        System.out.println("6.- Salir");

        System.out.println("Seleccione número de opción: ");
        return leer.LeerEntero();
    }

    public int MenuTareas(){
        System.out.println("MENU DE TAREAS");
        System.out.println("1. Agregar nueva tarea");
        System.out.println("2. Eliminar tarea");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Regresar al menu principal");

        System.out.println("Seleccione número de opción: ");
        return leer.LeerEntero();
    }
}
