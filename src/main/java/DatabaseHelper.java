import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DatabaseHelper {
    private static Connection connection;
    private static String driver;
    private static String url;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
    }

    private static Connection connection() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
            Class.forName(driver);
            connection = DriverManager.getConnection(url);
        }
        return connection;
    }

    public static Integer getPrivilege(User user) throws SQLException, ClassNotFoundException {
        String query = "SELECT privilege FROM credentials WHERE login = ? AND password = ?";
        PreparedStatement statement = connection().prepareStatement(query);
        statement.setString(1, user.login());
        statement.setString(2, user.password());
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("privilege");
        } else return -1;
    }

}
