import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
        public static Connection getConnection() throws SQLException {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user", "postgres", "123456");
            return con;
    }
}
