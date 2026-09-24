import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Lanzador lanzador = new Lanzador();

        System.out.println("¿Qué nivel quieres usar? (1, 2, 3 o 4):");
        String nivel = scanner.nextLine().trim();

        if (nivel.equals("1")){
            ejecutarNivel1(scanner, lanzador);
        } else {
            System.out.println("Ese nivel no esta");
        }
        scanner.close();
    }

    private static void ejecutarNivel1(Scanner scanner, Lanzador lanzador){
        while(true){
            System.out.println("Introduce un número (o 'salir' para terminar):");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("Salir")){
                System.out.println("Saliendo del programa");
                break;
            }
            int exitCode = lanzador.ejecutaFactor(entrada);
            System.out.println("Operación completada. Código de salida:" + exitCode);
        }
    }
}
