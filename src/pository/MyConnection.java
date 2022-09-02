package pository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

        public static Connection getConnection() throws SQLException {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            if (con != null) { System.out .println("Successfully connected to MySQL database test"); }


            return con;
    }
}
