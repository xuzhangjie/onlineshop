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


    /**
     * @Description: 用户从购物车中删除商品
     * @Param shopId: 商店di
     * @Param name: 商品名
     * @Param userId: 当前登录用户id
     * @return java.lang.String
     * @date 2021/5/3 11:47
    */
    public static String delete(Integer shopId,String name,Integer userId) throws ClassNotFoundException, SQLException {


        String sql = "DELETE FROM S_CART WHERE SHOPID=? AND NAME=? AND USERID=?";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(URL,"scott","tiger");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,shopId);
        preparedStatement.setString(2,name);
        preparedStatement.setInt(3,userId);

        preparedStatement.execute();

        preparedStatement.close();
        connection.close();

        return "删除成功";
    }

    /**
     * @Description: 从商店添加商品回购物车
     * @Param name: 商品名
     * @Param shopId: 商店id
     * @Param userId: 用户id
     * @return java.lang.String
     * @date 2021/5/3 12:06
    */
    public static String addCart(String name,Integer shopId,Integer userId) throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO S_CART(USERID,SHOPID,NAME,NUM) VALUES (?,?,?,?)";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(URL,"scott","tiger");
        PreparedStatement preparedStatement = connection.prepareCall(sql);

        preparedStatement.setInt(1,userId);
        preparedStatement.setInt(2,shopId);
        preparedStatement.setString(3,name);
        preparedStatement.setInt(4,1);

        preparedStatement.execute();

        preparedStatement.close();
        connection.close();

        return "添加成功";

    }

    /**
     * @Description: 返回用户购物车中所有商品的总额
     * @Param userid: 用户
     * @return java.lang.Double
     * @date 2021/5/3 12:20
    */
    public static Double getTotalPrice(Integer userid) throws ClassNotFoundException, SQLException {

        String sql = "SELECT SUM(SPRICE) FROM S_CART C LEFT JOIN S_STOCK S ON C.SHOPID=S.SHOPID AND C.NAME=S.SNAME WHERE C.USERID=?";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(URL,"scott","tiger");
        PreparedStatement preparedStatement = connection.prepareCall(sql);

        preparedStatement.setInt(1,userid);

        ResultSet rs = preparedStatement.executeQuery();

        rs.next();

        Double totalPrice =rs.getDouble(1);

        return totalPrice;



    }


}
