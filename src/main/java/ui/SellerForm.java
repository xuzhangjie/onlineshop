/*
 * Created by JFormDesigner on Thu Apr 29 11:25:56 CST 2021
 */

package ui;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class SellerForm extends JFrame {
    public SellerForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menuItem6 = new JMenuItem();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u4e2a\u4eba\u4fe1\u606f\u7ba1\u7406");
                menu1.setMaximumSize(new Dimension(93, 32767));
                menu1.setPreferredSize(new Dimension(93, 21));

                //---- menuItem1 ----
                menuItem1.setText("\u4fee\u6539\u5bc6\u7801");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u67e5\u8be2\u4e2a\u4eba\u4fe1\u606f");
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u5229\u6da6\u7edf\u8ba1");

                //---- menuItem4 ----
                menuItem4.setText("\u65e5\u5229\u6da6");
                menu2.add(menuItem4);

                //---- menuItem3 ----
                menuItem3.setText("\u6708\u5229\u6da6");
                menu2.add(menuItem3);
            }
            menuBar1.add(menu2);

            //---- menuItem5 ----
            menuItem5.setText("\u8ba2\u5355\u67e5\u8be2");
            menuBar1.add(menuItem5);

            //---- menuItem7 ----
            menuItem7.setText("\u5546\u54c1\u8fdb\u8d27");
            menuBar1.add(menuItem7);

            //---- menuItem6 ----
            menuItem6.setText("\u9000\u51fa\u767b\u5f55");
            menuBar1.add(menuItem6);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 650, 500);

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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenuItem menuItem3;
    private JMenuItem menuItem5;
    private JMenuItem menuItem7;
    private JMenuItem menuItem6;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
