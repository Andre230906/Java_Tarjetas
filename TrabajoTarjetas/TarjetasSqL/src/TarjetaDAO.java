import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDAO {

    public void guardarTarjeta(Tarjeta tarjeta) throws SQLException {
        String sql = "INSERT INTO Tarjetas (numero_cuenta, monto_apertura, tipo_tarjeta, anho) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tarjeta.getNumeroCuenta());
            stmt.setDouble(2, tarjeta.getMontoApertura());
            stmt.setString(3, tarjeta.getClass().getSimpleName());
            stmt.setString(4, "2024"); // Año de ejemplo
            stmt.executeUpdate();
        }
    }

    public List<Tarjeta> obtenerTodasLasTarjetas() throws SQLException {
        List<Tarjeta> tarjetas = new ArrayList<>();
        String sql = "SELECT * FROM Tarjetas";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String tipoTarjeta = rs.getString("tipo_tarjeta");
                Tarjeta tarjeta = null;
                if (tipoTarjeta.equals("Joven")) {
                    tarjeta = new Joven(rs.getString("numero_cuenta"), rs.getDouble("monto_apertura"));
                } else if (tipoTarjeta.equals("Nomina")) {
                    tarjeta = new Nomina(rs.getString("numero_cuenta"), rs.getDouble("monto_apertura"));
                } else if (tipoTarjeta.equals("Visa")) {
                    tarjeta = new Visa(rs.getString("numero_cuenta"), rs.getDouble("monto_apertura"));
                }
                tarjetas.add(tarjeta);
            }
        }
        return tarjetas;
    }
}
