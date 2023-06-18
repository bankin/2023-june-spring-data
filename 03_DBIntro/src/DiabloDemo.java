import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DiabloDemo {
    private static final String SELECT_USER_GAMES_COUNT_BY_USERNAME =
            "SELECT first_name, last_name, COUNT(ug.game_id) " +
            "FROM users AS u " +
            "JOIN users_games AS ug ON ug.user_id = u.id " +
            "WHERE user_name = ?";

    private static final String SELECT_USER_COUNT_BY_USERNAME =
            "SELECT COUNT(*) FROM users WHERE user_name = ?";

    public static void main(String[] args) throws SQLException {
        Connection connection = getMySQLConnection();

        String username = readUsername();

        boolean usernameExists = getUsernameExists(connection, username);

        PreparedStatement statement = connection.prepareStatement(SELECT_USER_GAMES_COUNT_BY_USERNAME);
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();

        if (usernameExists) {
            result.next();

            System.out.println("User: " + username);
            System.out.printf("%s %s has played %d games",
                result.getString("first_name"),
                result.getString("last_name"),
                result.getInt(3));
        } else {
            System.out.println("No such user exists");
        }
    }

    private static boolean getUsernameExists(Connection connection, String username) throws SQLException {
        PreparedStatement existsStatement = connection.prepareStatement(SELECT_USER_COUNT_BY_USERNAME);
        existsStatement.setString(1, username);

        ResultSet existsResult = existsStatement.executeQuery();
        existsResult.next();

        int rowCount = existsResult.getInt(1);

        return rowCount > 0;
    }

    private static String readUsername() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        return username;
    }

    private static Connection getMySQLConnection() throws SQLException {
        Properties userPass = new Properties();
        userPass.setProperty("user", "root");
        userPass.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/diablo", userPass);
//        Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/diablo", "root", "12345");

        return connection;
    }
}
