package test;

import java.sql.*;

public class huoqu {
    static  final String User = "root";
    static final String password = "123456";
    static final String url = "jdbc:mysql://localhost:3306/test";
    public static Connection getConnection(){
        Connection co = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                co = DriverManager.getConnection(url,User,password);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return co;
    }
    public static void close(Statement statement, Connection connection, ResultSet resultSet){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
