/*
 * Created by JFormDesigner on Thu Apr 29 11:22:24 CST 2021
 */

package ui;

import jdbc.CommodityJDBC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class Index extends JFrame {

    public static void main(String[] args) {
        new Index();
    }


    public Index() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menuItem1 = new JMenuItem();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //---- menuItem1 ----
            menuItem1.setText("\u8d2d\u4e70\u7269\u54c1\u8bf7\u767b\u5f55");
            menuBar1.add(menuItem1);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 655, 460);

        //---- button1 ----
        button1.setText("\u6d4f\u89c8\u5546\u5e97");
        contentPane.add(button1);
        button1.setBounds(0, 460, 655, 25);

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

        setVisible(true);//让首页可见
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭时候，进程也结束

        //Index首页表格显示商品
        try {
            String[] head = (String[]) CommodityJDBC.getCommodity().get(1);
            Object[][] objects =(Object[][]) CommodityJDBC.getCommodity().get(0);
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

        // 点击浏览商店按钮时进行刷新
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String[] head = (String[]) CommodityJDBC.getCommodity().get(1);
                            Object[][] objects =(Object[][]) CommodityJDBC.getCommodity().get(0);
                            DefaultTableModel tableModel = new DefaultTableModel(objects,head){
                                public boolean isCellEditabel(int row,int colum){
                                    return false;
                                }
                            };
                            table1.setModel(tableModel);
                        } catch (ClassNotFoundException ce) {
                            ce.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }



        );


        menuItem1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LoginForm loginForm = new LoginForm();
                        setVisible(false);
                        loginForm.setVisible(true);
                    }
                }
        );


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenuItem menuItem1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
