import java.sql.*;

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


        } catch (SQLException ex) {
            //throw new RuntimeException(ex);
        }

    }
}

