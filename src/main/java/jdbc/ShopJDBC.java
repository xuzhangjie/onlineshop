package jdbc;

import pojo.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pangjian
 * @ClassName ShopJDBC
 * @Description 商店数据库访问类
 * @date 2021/4/30 10:12
 */

public class ShopJDBC {

    private static final String URL = "jdbc:oracle:thin:@47.119.128.150:1521:orcl";

    private static final String[] HEAD = {"序号","商店名","所在地"};

    private static Object[][] data =null;


    /**
     * @Description:获得取商店id，名字，所在地
     * @return java.util.List
     * @date 2021/4/30 10:30
    */
    public static List getShop() throws ClassNotFoundException, SQLException {

        List resultList = new ArrayList();

        String sql = "SELECT * FROM S_SHOP";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(URL,"scott","tiger");

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(sql);

        List<Shop> list = new ArrayList();

        while (rs.next()){

            Shop shop = new Shop();
            shop.setId(rs.getInt("ID"));
            shop.setName(rs.getString("NAME"));
            shop.setArea(rs.getString("AREA"));

            list.add(shop);

        }

        data = new Object[list.size()][HEAD.length];
        //把集合里的数据放到Object这个二维数组里面
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < HEAD.length; j++) {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getName();
                data[i][2] = list.get(i).getArea();
            }
        }

        resultList.add(data);
        resultList.add(HEAD);

        rs.close();
        statement.close();
        connection.close();

        return resultList;

    }

}
