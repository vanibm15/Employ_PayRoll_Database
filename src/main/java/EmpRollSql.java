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
//           statement.executeUpdate("insert into employee(name,salary,department, joining_date) values ('vani',400000, 'cs-engg','2020-12-09')," +
//                    "('Praveen',50000, 'mech-engg','2018-09-06'),('Shreyas',600000, 'ee-engg','2023-11-08'),('Varsh',900000, 'IT','2001-06-07')");
            ResultSet resultSet = statement.executeQuery("select * from employee where Joining_Date between '2001-06-08' and '2018-09-06'");
            while (resultSet.next())
            {
                System.out.println("id:" + resultSet.getInt("id"));
                System.out.println("name:" + resultSet.getString("name"));
                System.out.println("salary:" + resultSet.getDouble("salary"));
                System.out.println("department:" + resultSet.getString("department"));
                System.out.println("Joining_Date:" + resultSet.getDate("Joining_Date"));


            }

        } catch (Exception e) {
            // e.printStackTrace();


        }
    }
}

