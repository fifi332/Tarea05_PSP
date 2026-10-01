import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {

    public int ejecutarNivel1(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            Process p = pb.start();

            BufferedReader lector1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea1;
            while ((linea1 = lector1.readLine()) != null) {
                System.out.println(linea1);
            }

            BufferedReader lector2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String linea2;
            while ((linea2 = lector2.readLine()) != null) {
                System.out.println(linea2);
            }

            return p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            return 1;
        }
    }

    public int ejecutarNivel2(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            Process p = pb.start();

            BufferedReader lector1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea1;
            while ((linea1 = lector1.readLine()) != null) {
                System.out.println("[OK] " + linea1);
            }

            BufferedReader lector2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String linea2;
            while ((linea2 = lector2.readLine()) != null) {
                System.out.println("[ERROR] " + linea2);
            }

            return p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            return 1;
        }
    }

    public int ejecutarNivel3(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("factor_output.log")));
            pb.redirectError(ProcessBuilder.Redirect.appendTo(new File("factor_error.log")));

            Process p = pb.start();
            return p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            return 1;
        }
    }

    public int ejecutarNivel4(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            Process p = pb.start();

            BufferedReader lector1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea1 = lector1.readLine();
            if (linea1 != null) {
                System.out.println(linea1);
            }

            BufferedReader lector2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String linea2 = lector2.readLine();
            if (linea2 != null) {
                System.out.println(linea2);
            }

            try {
                int n = Integer.parseInt(numero);
                if (esPrimo(n)) {
                    System.out.println("¡" + numero + " es primo!");
                } else {
                    System.out.println(numero + " no es primo");
                }
            } catch (NumberFormatException e) {
            }

            return p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            return 1;
        }
    }

    private boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}