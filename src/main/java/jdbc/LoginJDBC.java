package jdbc;

import oracle.jdbc.driver.OracleDriver;
import utils.MD5Utils;

import java.sql.*;

/**
 * @author pangjian
 * @ClassName LoginJDBC
 * @Description 查找用户账号和密码，认证通过则返回用户角色
 * @date 2021/4/24 10:45
 */

public class LoginJDBC {

    private static final String URL = "jdbc:oracle:thin:@47.119.128.150:1521:orcl";

    public static String login(String username,String password) throws ClassNotFoundException, SQLException {


        String sql = "SELECT * FROM S_USER WHERE USERNAME='"+username+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection(URL,"scott","tiger");

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        resultSet.next();
        String codePassword=resultSet.getString("password");
        String role = resultSet.getString("role");
        String userPassword = MD5Utils.code(password);// 加密后对比
        if(userPassword.equals(codePassword)){
            resultSet.close();
            statement.close();
            conn.close();
            return role; //返回用户角色
        }else {
            resultSet.close();
            statement.close();
            conn.close();
            throw new RuntimeException("账号或密码错误!");//抛出异常
        }

    }

}
