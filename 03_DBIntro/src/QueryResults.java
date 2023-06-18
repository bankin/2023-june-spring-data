import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class QueryResults {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "12345");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soft_uni", props);
        connection.setAutoCommit(false);

        System.out.println("Enter User ID");
        String userId = sc.nextLine();

        String query = "SELECT * FROM employees WHERE employee_id = ";
        query += userId;
        System.out.println(query);

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
        preparedStatement.setString(1, userId);
        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();
        connection.commit();
//
//        Statement statement = connection.createStatement();
//        statement.execute(query);

        while(rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }



        connection.close();
    }
}
