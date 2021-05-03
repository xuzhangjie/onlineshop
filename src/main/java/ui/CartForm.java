/*
 * Created by JFormDesigner on Fri Apr 30 12:26:12 CST 2021
 */

package ui;

import jdbc.CartJDBC;
import jdbc.ShopJDBC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class CartForm extends JFrame {

    //当前购物车的用户
    private Integer userId;
    //进入购物车前浏览的商店
    private Integer shopId;


    public CartForm(Integer userId,Integer shopId) {
        this.userId = userId;
        this.shopId = shopId;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        label2 = new JLabel();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 35, 985, 480);

        //---- label1 ----
        label1.setText("\u6211\u7684\u8d2d\u7269\u8f66");
        contentPane.add(label1);
        label1.setBounds(450, 0, 210, 35);

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(10, 5), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u4ece\u8d2d\u7269\u8f66\u5220\u9664\u8be5\u5546\u54c1");
        contentPane.add(button2);
        button2.setBounds(10, 525, 205, 45);

        //---- button4 ----
        button4.setText("\u4ed8\u6b3e\u7801\u652f\u4ed8");
        contentPane.add(button4);
        button4.setBounds(460, 525, 240, 40);

        //---- label2 ----
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        contentPane.add(label2);
        label2.setBounds(220, 530, 80, 35);

        //---- button3 ----
        button3.setText("\u626b\u7801\u652f\u4ed8");
        contentPane.add(button3);
        button3.setBounds(715, 525, 240, 40);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


        // 显示购物车列表
        try {
            java.util.List list = CartJDBC.getCart(userId);
            Object[][] objects = (Object[][]) list.get(0);
            String[] head =(String[]) list.get(1);
            DefaultTableModel tableModel = new DefaultTableModel(objects,head){
                public boolean isCellEditabel(int row,int colum){
                    return false;
                }
            };
            table1.setModel(tableModel);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 从购物车中删除所选择的商品
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = table1.getSelectedRow();
                        Integer shopId =(Integer) table1.getValueAt(count,0);
                        String name = table1.getValueAt(count,1).toString();
                        try {
                            String msg = CartJDBC.delete(shopId,name,userId);
                            System.out.println(msg);
                            //删除后刷新
                            java.util.List list = CartJDBC.getCart(userId);
                            Object[][] objects = (Object[][]) list.get(0);
                            String[] head =(String[]) list.get(1);
                            DefaultTableModel tableModel = new DefaultTableModel(objects,head){
                                public boolean isCellEditabel(int row,int colum){
                                    return false;
                                }
                            };
                            table1.setModel(tableModel);
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
        );

        // 返回刚刚正在浏览的商店首页
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BuyersForm buyersForm = new BuyersForm(userId,shopId);
                        buyersForm.setVisible(true);
                        setVisible(false);
                    }
                }
        );

        //统计用户购物车下所有商品的总额
        try {
            Double totalPrice = CartJDBC.getTotalPrice(userId);
            label2.setText("总额:"+totalPrice);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JLabel label2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
