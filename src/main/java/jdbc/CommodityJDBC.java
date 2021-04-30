package jdbc;

import pojo.Commodity;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pangjian
 * @ClassName CommodityJDBC
 * @Description 商品数据库访问类
 * @date 2021/4/26 13:01
 */

public class CommodityJDBC {

    private static final String URL = "jdbc:oracle:thin:@47.119.128.150:1521:orcl";

    private static final String[] HEAD={"商品名称","剩售数量","单价"};

    private static Object[][] data =null;

    /**
     * @Description:返回某个商铺所有的商品
     * @return java.util.List<pojo.Commodity>
     * @date 2021/4/27 22:44
    */
    public static List getCommodity(Integer id) throws ClassNotFoundException, SQLException {

        List retrunList = new ArrayList();

        List<Commodity> list = new ArrayList<>();

        String sql = "SELECT * FROM S_STOCK WHERE SAMT > 0 AND SHOPID= "+id;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection(URL,"scott","tiger");

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            Commodity commodity = new Commodity();
            commodity.setName(resultSet.getString("sname"));
            commodity.setAmt(resultSet.getInt("samt"));
            commodity.setPrice(resultSet.getDouble("sprice"));
            list.add(commodity);
        }

        data = new Object[list.size()][HEAD.length];
        //把集合里的数据放到Object这个二维数组里面
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < HEAD.length; j++) {
                data[i][0] = list.get(i).getName();
                data[i][1] = list.get(i).getAmt();
                data[i][2] = list.get(i).getPrice();
            }
        }

        retrunList.add(data);
        retrunList.add(HEAD);


        resultSet.close();
        statement.close();
        conn.close();

        return retrunList;

    }

    /**
     * @Description:库存减少，生成订单记录，生成利润记录
     * @return java.lang.String
     * @date 2021/4/27 22:45
    */
    public static String saleCommodity(List<Commodity> list) throws SQLException {


        String sql ="call proc_order(?,?,?,?)";

        Connection connection = DriverManager.getConnection(URL,"scott","tiger");

        CallableStatement callableStatement = connection.prepareCall(sql);

        for (Commodity commodity:
            list ) {
            callableStatement.setString(1,commodity.getName());
            callableStatement.setDouble(2,commodity.getPrice());
            callableStatement.setInt(3,commodity.getNum());
            callableStatement.setInt(4,commodity.getUserId());

            callableStatement.execute();
        }


        callableStatement.close();
        connection.close();

        return "购买成功";

    }




}
