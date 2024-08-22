import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    public void addFactura(Factura factura) throws SQLException {
        String sql = "INSERT INTO Facturas (cliente_id, fecha) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, factura.getCliente().getId());
            stmt.setDate(2, new java.sql.Date(factura.getFecha().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Factura> getAllFacturas() throws SQLException {
        List<Factura> facturas = new ArrayList<>();
        String sql = "SELECT * FROM Facturas";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new ClienteDAO().getClienteById(rs.getInt("cliente_id"));
                Factura factura = new Factura(rs.getInt("
