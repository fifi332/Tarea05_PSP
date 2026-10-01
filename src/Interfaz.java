import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lanzador lanzador = new Lanzador();

        System.out.println("¿Qué nivel quieres usar? (1, 2, 3 o 4):");
        String opcionNivel = scanner.nextLine().trim();

        while (true) {
            System.out.println("Introduce un número (o 'salir' para terminar):");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del programa");
                break;
            }

            int codigoSalida;

            switch (opcionNivel) {
                case "2":
                    codigoSalida = lanzador.ejecutarNivel2(input);
                    break;
                case "3":
                    codigoSalida = lanzador.ejecutarNivel3(input);
                    break;
                case "4":
                    codigoSalida = lanzador.ejecutarNivel4(input);
                    break;
                case "1":
                default:
                    codigoSalida = lanzador.ejecutarNivel1(input);
                    break;
            }

            System.out.println("Operación completada. Código de salida: " + codigoSalida);
        }

        scanner.close();
    }
}