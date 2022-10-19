import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Código hecho con comandos Linux
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("firefox");
        Process p = null;
        long tiempoInicial;
        long tiempoFinal;

        System.out.println("Introduzca el número de veces que desea abrir el navegador:");
        int navNum = sc.nextInt();

        for (int i = 0; i < navNum; i++) {
            try{
                tiempoInicial = System.currentTimeMillis();
                p = pb.start();
                p.waitFor(500, TimeUnit.MILLISECONDS);
                p.destroyForcibly();
                tiempoFinal = System.currentTimeMillis();
                System.out.println("El tiempo de ejecución del proceso es de: " + (tiempoFinal - tiempoInicial) + "ms");
            }
            catch (IOException | InterruptedException e) {
                System.out.println("Error al lanzar el proceso");
            }
        }
    }
}