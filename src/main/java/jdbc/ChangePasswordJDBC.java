package jdbc;

import utils.MD5Utils;

import java.sql.*;

public class ChangePasswordJDBC {
    private static final String URL = "jdbc:oracle:thin:@47.119.128.150:1521:orcl";

    public static Boolean checkPassword(String username, char[] password) throws ClassNotFoundException, SQLException {


        String sql = "SELECT PASSWORD FROM S_USER WHERE USERNAME=?";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection(URL, "scott", "tiger");

        //   Statement statement = conn.createStatement();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();

        resultSet.next();
        String codePassword = resultSet.getString("password");
        String userPassword = MD5Utils.code(new String(password));// 加密后对比
        if (userPassword.equals(codePassword)) {
            resultSet.close();
            statement.close();
            conn.close();
            return true;
        } else {
            resultSet.close();
            statement.close();
            conn.close();
            return false;
        }

    }
        public static Boolean updatePassword(String username, char[] password)  throws Exception {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(URL, "scott", "tiger");
            String codePassword=MD5Utils.code(new String(password));
            String sql = "UPDATE S_USER SET PASSWORD=?  WHERE USERNAME=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, codePassword);
            statement.setString(2, username);
            if(statement.executeUpdate()>0){
                return true;
            }else{
                return false;
            }



        }

}