/*
 * Created by JFormDesigner on Fri Apr 30 10:31:16 CST 2021
 */

package ui;

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
public class ShopForm extends JFrame {

    public static void main(String[] args) {
        new ShopForm();
    }

    public ShopForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(5, 0, 625, 505);

        //---- button1 ----
        button1.setText("\u8fdb\u5165\u5546\u5e97");
        contentPane.add(button1);
        button1.setBounds(5, 505, 625, 60);

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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭时候，进程也结束
        setVisible(true);//让初始首页可见

        // 显示商店列表
        try {
            String[] head = (String[]) ShopJDBC.getShop().get(1);
            Object[][] objects =(Object[][]) ShopJDBC.getShop().get(0);
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

        //选定进入商店
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = table1.getSelectedRow();//获取你选中的行号
                        Integer id =(Integer) table1.getValueAt(count,0);
                        String name = table1.getValueAt(count,1).toString();
                        ShopIndex index = new ShopIndex(name,id);
                        setVisible(false);
                        index.setVisible(true);

                    }
                }
        );



    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
