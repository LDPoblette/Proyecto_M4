import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    Scanner sc = new Scanner(System.in);

    public int LeerEntero() {

        while (true){
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                System.out.print("Por favor escribir un número del menú");
            }
        }
    }

    public String LeerString() {
        return sc.nextLine();
    }
}
