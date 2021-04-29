/*
 * Created by JFormDesigner on Sat Apr 24 09:47:09 CST 2021
 */

package ui;

import jdbc.LoginJDBC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author unknown
 */
public class LoginForm extends JFrame {


    public LoginForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(500, 500));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8d26\u53f7");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(95, 95), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(95, 135), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(150, 95, 235, 25);
        contentPane.add(textField2);
        textField2.setBounds(150, 135, 235, 30);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(95, 215), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u6ce8\u518c");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(265, 215), button2.getPreferredSize()));

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

        // 监听点击登录事件发生
        button1.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String username = textField1.getText();
                        String password = textField2.getText();

                        try {
                            String role = LoginJDBC.login(username, password);
                            System.out.println("登录成功");
                            if (role.equals("买家")) {
                                // 如果是买家显示商品展示页面

                                setVisible(false);// 登录成功的情况下隐藏登录界面
                            } else {

                            }
                        } catch (ClassNotFoundException ec) {
                            ec.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (RuntimeException re) {
                            // 账号或者密码错误
                            System.out.println(re.getMessage());
                        }
                    }
                }
        );
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
