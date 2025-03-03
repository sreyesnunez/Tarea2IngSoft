package mx.ipn.escom.HolaSpring6CV3.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionTest {

    // Parámetros de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/tarea2?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root"; // Usuario de la BD
    private static final String PASSWORD = ""; // Contraseña de la BD

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Conectar a la base de datos
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos MySQL");

        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos: " + e.getMessage());

        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("🔌 Conexión cerrada");
                }
            } catch (SQLException e) {
                System.out.println("⚠️ Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
