/*
 * Created by JFormDesigner on Mon Apr 26 11:08:05 CST 2021
 */

package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author 1
 */
public class BuyersForm extends JFrame {


    private static Integer userId;
    private static Integer shopId;

    public BuyersForm(Integer userId,Integer shopId) {
        initComponents();
        this.userId=userId;
        this.shopId=shopId;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem9 = new JMenuItem();
        menuItem8 = new JMenuItem();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        menuItem7 = new JMenuItem();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {


            //---- menuItem6 ----
            menuItem6.setText("\u6d88\u8d39\u8be6\u60c5");
            menuBar1.add(menuItem6);

            //---- menuItem5 ----
            menuItem5.setText("\u8ba2\u5355\u67e5\u8be2");
            menuBar1.add(menuItem5);

            //---- menuItem9 ----
            menuItem9.setText("\u8d2d\u7269\u8f66");
            menuBar1.add(menuItem9);

            //---- menuItem8 ----
            menuItem8.setText("\u9000\u51fa\u767b\u5f55");
            menuBar1.add(menuItem8);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 660, 410);

        //---- menuItem7 ----
        menuItem7.setText("text");
        contentPane.add(menuItem7);
        menuItem7.setBounds(new Rectangle(new Point(540, -20), menuItem7.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
        contentPane.add(button1);
        button1.setBounds(0, 410, 620, 30);

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


        // 选择商品加入购物车
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = table1.getSelectedRow();
                        String name =table1.getValueAt(count,0).toString();

                    }
                }
        );

        //查看购物车
        menuItem9.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CartForm cartForm = new CartForm(userId,shopId);
                        cartForm.setVisible(true);
                        setVisible(false);
                    }
                }
        );


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem6;
    private JMenuItem menuItem5;
    private JMenuItem menuItem9;
    private JMenuItem menuItem8;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JMenuItem menuItem7;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
