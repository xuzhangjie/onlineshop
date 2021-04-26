package jdbc;

import oracle.jdbc.driver.OracleDriver;
import utils.MD5Utils;

import java.sql.*;

/**
 * @author pangjian
 * @ClassName LoginJDBC
 * @Description TODO
 * @date 2021/4/24 10:45
 */

public class LoginJDBC {

    public static String login(String username,String password) throws ClassNotFoundException, SQLException {


        String url = "jdbc:oracle:thin:@47.119.128.150:1521:orcl";

        String sql = "SELECT * FROM S_USER WHERE USERNAME='"+username+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection(url,"scott","tiger");

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        resultSet.next();
        String codePassword=resultSet.getString("password");
        String role = resultSet.getString("role");
        String userPassword = MD5Utils.code(password);
        if(userPassword.equals(codePassword)){
            return role;
        }else {
            throw new RuntimeException("账号或密码错误!");
        }

    }

}
