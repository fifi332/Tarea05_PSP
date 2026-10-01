import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {


    public int ejecutarNivel1(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("wsl", "factor", numero);
            Process proceso = pb.start();

            // Leer flujo de salida estándar
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            // Leer flujo de error
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
            String errorLinea;
            while ((errorLinea = errorReader.readLine()) != null) {
                System.out.println(errorLinea);
            }

            // waitFor() siempre al final tras leer los flujos
            return proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el proceso: " + e.getMessage());
            return 1;
        }
    }


    public int ejecutarNivel2(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            Process proceso = pb.start();

            // Cada canal se etiqueta de forma independiente línea por línea
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("[OK] " + linea);
            }

            BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
            String errorLinea;
            while ((errorLinea = errorReader.readLine()) != null) {
                System.out.println("[ERROR] " + errorLinea);
            }

            return proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("[ERROR] Error al ejecutar el proceso: " + e.getMessage());
            return 1;
        }
    }


    public int ejecutarNivel3(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            // Nombres exactos exigidos en el enunciado y modo append (añadir)
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("factor_output.log")));
            pb.redirectError(ProcessBuilder.Redirect.appendTo(new File("factor_error.log")));

            Process proceso = pb.start();
            return proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al redirigir salida a ficheros: " + e.getMessage());
            return 1;
        }
    }


    public int ejecutarNivel4(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            Process proceso = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String salida = reader.readLine();

            if (salida != null) {
                System.out.println(salida);

                // factor devuelve "n: n" únicamente cuando n es primo
                String patronPrimo = numero + ": " + numero;
                if (salida.trim().equals(patronPrimo)) {
                    System.out.println("¡" + numero + " es primo!");
                } else {
                    System.out.println(numero + " no es primo");
                }
            }

            BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
            String error = errorReader.readLine();
            if (error != null) {
                System.out.println(error);
            }

            return proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el proceso: " + e.getMessage());
            return 1;
        }
    }
}