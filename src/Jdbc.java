import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {


    static String url = "jdbc:postgresql://localhost:5432/SaglikOcagiSistemi";
    static Connection connection = null;
    public static Connection baglan() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, "postgres", "382102");
        }
        return connection;
    }

     void kapat() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

