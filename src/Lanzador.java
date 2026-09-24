import java.io.IOException;

public class Lanzador {
    public int ejecutaFactor(String entrada){
        try{
            ProcessBuilder pb = new ProcessBuilder("factor", entrada);

            pb.inheritIO();
            Process p = pb.start();
            int exitCode = p.waitFor();

            return exitCode;
        } catch (IOException e){
            System.out.println("Error de E/S al intertar ejecutar el comando factor");
            return -1;
        }catch (InterruptedException e){
            System.out.println("Se interrumpio");
            return -1;
        }
    }
}
