import java.util.Date;
import java.util.List;

public class Factura {
    private Clientes cliente;
    private Date fecha;
    private List<Producto> productos;

    public Factura(int id, Clientes cliente, Date fecha, List<Producto> productos) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.productos = productos;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total * cliente.getTipoCliente().getDescuento(); 
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
