import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cartera cartera = new Cartera("2024");

        while (true) {
            System.out.println("\n--- Gestión de Tarjetas ---");
            System.out.println("1. Agregar Tarjeta");
            System.out.println("2. Mostrar Tarjetas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número de cuenta: ");
                    String numeroCuenta = scanner.nextLine();
                    System.out.print("Ingrese el monto de apertura: ");
                    double montoApertura = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer

                    System.out.println("Seleccione el tipo de tarjeta:");
                    System.out.println("1. Joven");
                    System.out.println("2. Nomina");
                    System.out.println("3. Visa");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    Tarjeta tarjeta = null;
                    if (tipo == 1) {
                        tarjeta = new Joven(numeroCuenta, montoApertura);
                    } else if (tipo == 2) {
                        tarjeta = new Nomina(numeroCuenta, montoApertura);
                    } else if (tipo == 3) {
                        tarjeta = new Visa(numeroCuenta, montoApertura);
                    }

                    if (tarjeta != null) {
                        cartera.agregarTarjeta(tarjeta);
                        System.out.println("Tarjeta agregada exitosamente.");
                    } else {
                        System.out.println("Tipo de tarjeta no válido.");
                    }
                    break;

                case 2:
                    cartera.imprimirListaDeTarjetas();
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
