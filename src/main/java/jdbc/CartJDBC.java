package jdbc;

import pojo.Commodity;
import pojo.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pangjian
 * @ClassName CartJDBC
 * @Description 购物车类
 * @date 2021/4/30 11:36
 */

public class CartJDBC {

    private static final String URL = "jdbc:oracle:thin:@47.119.128.150:1521:orcl";

    private static final String[] HEAD = {"商店号","商品名","待购数量"};

    private static Object[][] data =null;

    /**
     * @Description: 获取该用户购物车的全部商品
     * @Param userId: 用户id
     * @return java.util.List
     * @date 2021/4/30 12:49
    */
    public static List getCart(Integer userId) throws ClassNotFoundException, SQLException {

        List resultList = new ArrayList();

        String sql = "SELECT SHOPID,NAME,SUM(NUM) FROM S_CART WHERE USERID=? GROUP BY SHOPID,NAME";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(URL,"scott","tiger");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,userId);

        ResultSet rs = preparedStatement.executeQuery();

        List<Commodity> list = new ArrayList();

        while (rs.next()){
            Commodity commodity = new Commodity();
            commodity.setShopId(rs.getInt("SHOPID"));
            commodity.setName(rs.getString("NAME"));
            commodity.setNum(rs.getInt("SUM(NUM)"));

            list.add(commodity);

        }

        data = new Object[list.size()][HEAD.length];
        //把集合里的数据放到Object这个二维数组里面
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < HEAD.length; j++) {
                data[i][0] = list.get(i).getShopId();
                data[i][1] = list.get(i).getName();
                data[i][2] = list.get(i).getNum();
            }
        }
        resultList.add(data);
        resultList.add(HEAD);

        rs.close();
        preparedStatement.close();
        connection.close();

        return resultList;
    }


}
