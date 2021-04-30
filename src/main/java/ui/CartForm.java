/*
 * Created by JFormDesigner on Fri Apr 30 12:26:12 CST 2021
 */

package ui;

import jdbc.CartJDBC;
import jdbc.ShopJDBC;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class CartForm extends JFrame {

    private Integer userId;
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
        button3 = new JButton();
        button4 = new JButton();

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
        button2.setText("text");
        contentPane.add(button2);
        button2.setBounds(10, 525, 205, 45);

        //---- button3 ----
        button3.setText("text");
        contentPane.add(button3);
        button3.setBounds(235, 525, 205, 45);

        //---- button4 ----
        button4.setText("text");
        contentPane.add(button4);
        button4.setBounds(460, 525, 240, 40);

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
            Object[][] objects =(Object[][])list.get(0);
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



    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
