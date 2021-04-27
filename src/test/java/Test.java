import jdbc.CommodityJDBC;
import pojo.Commodity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pangjian
 * @ClassName Test
 * @Description TODO
 * @date 2021/4/26 11:33
 */

public class Test {

    public static void main(String[] args) {
        try {
            List<Commodity> list = new ArrayList<>();
            Commodity commodity = new Commodity("001","纯生啤酒",81,6.00,10);
            list.add(commodity);
            String msg = CommodityJDBC.saleCommodity(list);
            System.out.println(msg);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
