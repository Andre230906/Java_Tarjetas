import java.sql.SQLException;
import java.util.List;

public class Cartera implements PatronCartera {
    private String anho;
    private TarjetaDAO tarjetaDAO;

    public Cartera(String anho) {
        this.anho = anho;
        this.tarjetaDAO = new TarjetaDAO();
    }

    @Override
    public void agregarTarjeta(Tarjeta t) {
        try {
            tarjetaDAO.guardarTarjeta(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void imprimirListaDeTarjetas() {
        try {
            List<Tarjeta> tarjetas = tarjetaDAO.obtenerTodasLasTarjetas();
            for (Tarjeta t : tarjetas) {
                System.out.println("Cuenta: " + t.getNumeroCuenta() +
                                   ", Cuota de Manejo: " + t.cuotaDeManejo() +
                                   ", Tipo: " + t.getClass().getSimpleName() +
                                   ", Año: " + anho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
