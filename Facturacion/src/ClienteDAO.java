import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void addCliente(Clientes cliente) throws SQLException {
        String sql = "INSERT INTO Clientes (nombre) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNombre());
            stmt.executeUpdate();
        }
    }

    public List<Clientes> getAllClientes() throws SQLException {
        List<Clientes> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Clientes cliente = new Clientes(rs.getInt("id"), rs.getString("nombre"), TipoCliente.CLIENTE_BASICO);
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public Clientes getClienteById(int id) throws SQLException {
        Clientes cliente = null;
        String sql = "SELECT * FROM Clientes WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Clientes(rs.getInt("id"), rs.getString("nombre"), TipoCliente.CLIENTE_BASICO);
                }
            }
        }
        return cliente;
    }

}
