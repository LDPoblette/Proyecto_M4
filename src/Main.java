public class Main {
    public static void main(String[] args) {
        ListasTareas listasTareas = new ListasTareas();
        Menus menu = new Menus();
        int opcion = 0;

        do {
            opcion = menu.MenuPrincipal();

            switch (opcion){
                case 1:
                    listasTareas.crearListaTareas();
                    break;
                case 2:
                    listasTareas.verListasTareas();
                    break;
                case 3:
                    listasTareas.verTareasDeLista();
                    break;
                case 4:
                    listasTareas.actualizarListaTareas();
                    break;
                case 5:
                    listasTareas.eliminarListaTareas();
                    break;
                case 6:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción invalida, digite un número de la lista");
                    break;
            }

        }while (opcion != 6);
    }
}