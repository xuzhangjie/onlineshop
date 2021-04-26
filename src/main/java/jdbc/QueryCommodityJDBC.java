package jdbc;

import pojo.Commodity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pangjian
 * @ClassName QueryCommodityJDBC
 * @Description 返回商品列表
 * @date 2021/4/26 13:01
 */

public class QueryCommodityJDBC {


    public static List<Commodity> getCommodity() throws ClassNotFoundException, SQLException {

        List<Commodity> list = new ArrayList<>();

        String url = "jdbc:oracle:thin:@47.119.128.150:1521:orcl";

        String sql = "SELECT * FROM S_STOCK ";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection(url,"scott","tiger");

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            Commodity commodity = new Commodity();
            commodity.setName(resultSet.getString("cname"));
            commodity.setAmt(resultSet.getInt("camt"));
            commodity.setPrice(resultSet.getDouble("cprice"));
            list.add(commodity);
        }
        resultSet.close();
        statement.close();
        conn.close();
        return list;

    }




}
