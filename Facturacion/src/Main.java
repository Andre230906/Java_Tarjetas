import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static ProductoDAO productoDAO = new ProductoDAO();
    private static FacturaDAO facturaDAO = new FacturaDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSistema de Facturación");
            System.out.println("1. Añadir Cliente");
            System.out.println("2. Añadir Producto");
            System.out.println("3. Crear Factura");
            System.out.println("4. Mostrar Clientes");
            System.out.println("5. Mostrar Productos");
            System.out.println("6. Mostrar Facturas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            try {
                switch (opcion) {
                    case 1:
                        agregarCliente(scanner);
                        break;
                    case 2:
                        agregarProducto(scanner);
                        break;
                    case 3:
                        crearFactura(scanner);
                        break;
                    case 4:
                        mostrarClientes();
                        break;
                    case 5:
                        mostrarProductos();
                        break;
                    case 6:
                        mostrarFacturas();
                        break;
                    case 7:
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void agregarCliente(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.println("Seleccione el tipo de cliente:");
        System.out.println("1. Cliente Básico (sin descuento)");
        System.out.println("2. Cliente Premium (10% de descuento)");
        System.out.println("3. Cliente Pedro (20% de descuento)");
        int tipo = scanner.nextInt();

        TipoCliente tipoCliente;
        switch (tipo) {
            case 1:
                tipoCliente = TipoCliente.CLIENTE_BASICO;
                break;
            case 2:
                tipoCliente = TipoCliente.CLIENTE_PREMIUM;
                break;
            case 3:
                tipoCliente = TipoCliente.CLIENTE_PEDRO;
                break;
            default:
                System.out.println("Tipo de cliente no válido. Se asignará como Cliente Básico.");
                tipoCliente = TipoCliente.CLIENTE_BASICO;
        }

        Clientes cliente = new Clientes(0, nombre, tipoCliente);
        clienteDAO.addCliente(cliente);
        System.out.println("Cliente añadido exitosamente.");
    }

    private static void agregarProducto(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(0, nombre, precio);
        productoDAO.addProducto(producto);
        System.out.println("Producto añadido exitosamente.");
    }

    private static void crearFactura(Scanner scanner) throws SQLException {
        System.out.print("Ingrese el ID del cliente: ");
        int clienteId = scanner.nextInt();

        Clientes cliente = clienteDAO.getClienteById(clienteId);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Ingrese la fecha de la factura (dd/MM/yyyy): ");
        String fechaStr = scanner.next();
        Date fecha;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
        } catch (Exception e) {
            System.out.println("Formato de fecha no válido. Se usará la fecha actual.");
            fecha = new Date();
        }

        List<Producto> productos = new ArrayList<>();
        while (true) {
            System.out.print("Ingrese el ID del producto (0 para finalizar): ");
            int productoId = scanner.nextInt();

            if (productoId == 0) break;

            Producto producto = productoDAO.getAllProductos().stream()
                .filter(p -> p.getId() == productoId)
                .findFirst()
                .orElse(null);

            if (producto != null) {
                productos.add(producto);
                System.out.println("Producto añadido a la factura.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        }

        Factura factura = new Factura(0, cliente, fecha, productos);
        facturaDAO.addFactura(factura);
        System.out.println("Factura creada exitosamente. Total: " + factura.calcularTotal());
    }

    private static void mostrarClientes() throws SQLException {
        List<Clientes> clientes = clienteDAO.getAllClientes();
        System.out.println("\nLista de Clientes:");
        for (Clientes cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() + ", Tipo: " + cliente.getTipoCliente());
        }
    }

    private static void mostrarProductos() throws SQLException {
        List<Producto> productos = productoDAO.getAllProductos();
        System.out.println("\nLista de Productos:");
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
    }

    private static void mostrarFacturas() throws SQLException {
        List<Factura> facturas = facturaDAO.getAllFacturas();
        System.out.println("\nLista de Facturas:");
        for (Factura factura : facturas) {
            System.out.println("ID: " + factura.getId() + ", Cliente: " + factura.getCliente().getNombre() + ", Fecha: " + factura.getFecha());
            System.out.println("Productos en la factura:");
            for (Producto producto : factura.getProductos()) {
                System.out.println("\tNombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
            }
            System.out.println("Total con descuento: " + factura.calcularTotal());
        }
    }
}
