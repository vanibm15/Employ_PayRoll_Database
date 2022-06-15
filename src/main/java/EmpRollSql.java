import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpRollSql {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/emppayroll?useSSL=false";
        String username = "root";
        String password = "123456789";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("cannot find the driver in the classpath!", e);
        }
        try {
            System.out.println("connecting to database:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connection done successful!!" + con);
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from employee");
            while (resultSet.next())
            {
                System.out.println("id:" + resultSet.getInt("id"));
                System.out.println("name:" + resultSet.getString("name"));
                System.out.println("salary:" + resultSet.getString("salary"));
                System.out.println("department:" + resultSet.getDate("department"));
                System.out.println("Joining_Date:" + resultSet.getDouble("Joining_Date"));


            }

        } catch (Exception e) {
            // e.printStackTrace();


        }
    }
}

