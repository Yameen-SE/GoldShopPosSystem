import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL  = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "system";
    private static final String PASS = "Password";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver"); // optional with JDBC 4+
        } catch (ClassNotFoundException e) {
            throw new SQLException("Oracle JDBC driver not found", e);
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void main(String[] args) {
        try (Connection con = getConnection()) {
            System.out.println("Connected: " + !con.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
