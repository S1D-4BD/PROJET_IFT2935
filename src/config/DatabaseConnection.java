package config;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
// ici on va juste config la connexion a la db
// guys c est vrm important creez la db avec le nom ift2935 et votre user c'est postgres, le mdp c'est juste root

public class DatabaseConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/ift2935";
    private static final String user="postgres";
    private static final String psw="root";

    private static Connection connection = null;
    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("using existing connection");
                return connection;
            }
            else{
                connection = DriverManager.getConnection(url, user, psw);
                System.out.println("connected");
            }
        } catch (SQLException e) {
            System.out.println("connection error : " + e.getMessage());
        }
        return connection;
    }
}
