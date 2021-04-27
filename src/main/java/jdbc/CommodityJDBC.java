package jdbc;

import pojo.Commodity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pangjian
 * @ClassName CommodityJDBC
 * @Description 商品数据库访问类
 * @date 2021/4/26 13:01
 */

public class CommodityJDBC {

    private static final String URL = "jdbc:oracle:thin:@47.119.128.150:1521:orcl";


    /**
     * @Description:返回商铺所有的商品
     * @return java.util.List<pojo.Commodity>
     * @date 2021/4/27 22:44
    */
    public static List<Commodity> getCommodity() throws ClassNotFoundException, SQLException {

        List<Commodity> list = new ArrayList<>();

        String sql = "SELECT * FROM S_STOCK ";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection(URL,"scott","tiger");

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

    /**
     * @Description:库存减少，生成订单记录，生成利润记录
     * @return java.lang.String
     * @date 2021/4/27 22:45
    */
    public static String saleCommodity(List<Commodity> list) throws SQLException {


        String sql ="call proc_order(?,?,?)";

        Connection connection = DriverManager.getConnection(URL,"scott","tiger");

        CallableStatement callableStatement = connection.prepareCall(sql);

        for (Commodity commodity:
            list ) {
            callableStatement.setString(1,commodity.getName());
            callableStatement.setDouble(2,commodity.getPrice());
            callableStatement.setInt(3,commodity.getNum());

            callableStatement.execute();
        }


        callableStatement.close();
        connection.close();

        return "购买成功";

    }




}
