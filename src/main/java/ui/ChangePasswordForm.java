/*
 * Created by JFormDesigner on Wed May 05 11:44:43 CST 2021
 */

package ui;

import jdbc.ChangePasswordJDBC;
import utils.CreateImageCode;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 1
 */
public class ChangePasswordForm extends JFrame {
    public ChangePasswordForm(String username) throws IOException {
        this.username = username;
        CreateImageCode image = new CreateImageCode();
        this.code = image.getCode();
        saveImage(image);
        initComponents();
    }

    public void saveImage(CreateImageCode image) throws IOException {
        try {
            OutputStream os = new FileOutputStream("D:\\C++代码文件\\onlineshop\\resources\\clarifyImg.gif");
            image.write(os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() throws IOException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        button1 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        passwordField1 = new JPasswordField();
        panel2 = new JPanel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        button2 = new JButton();
        label8 = new JLabel();
        label9 = new JLabel();
        passwordField2 = new JPasswordField();
        passwordField3 = new JPasswordField();
        label10 = new JLabel();
        textField1 = new JTextField();
        label11 = new JLabel();
        textArea1 = new JTextArea();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u9a8c\u8bc1\u5f53\u524d\u5bc6\u7801");
            label1.setFont(new Font("\u6977\u4f53", Font.BOLD, 25));
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(170, 25), label1.getPreferredSize()));

            //---- button1 ----
            button1.setText("\u4e0b\u4e00\u6b65");
            button1.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
            button1.setForeground(Color.white);
            button1.setBackground(new Color(0, 204, 204));
            button1.setIcon(null);
            panel1.add(button1);
            button1.setBounds(165, 185, 180, 30);

            //---- label2 ----
            label2.setFont(new Font("\u6977\u4f53", Font.PLAIN, 18));
            panel1.add(label2);
            label2.setBounds(80, 60, 135, 25);

            //---- label3 ----
            label3.setText("\u5bc6\u7801");
            label3.setFont(new Font("\u6977\u4f53", Font.BOLD, 20));
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(140, 105), label3.getPreferredSize()));

            //---- label4 ----
            label4.setForeground(Color.red);
            label4.setFont(new Font("\u6977\u4f53", Font.PLAIN, 18));
            panel1.add(label4);
            label4.setBounds(195, 130, 130, 25);

            //---- passwordField1 ----
            passwordField1.setFont(new Font("\u6977\u4f53", Font.PLAIN, 14));
            panel1.add(passwordField1);
            passwordField1.setBounds(195, 105, 150, passwordField1.getPreferredSize().height);

            //======== panel2 ========
            {
                panel2.setForeground(Color.red);
                panel2.setBackground(Color.white);
                panel2.setLayout(null);

                //---- label5 ----
                label5.setText("\u4fee\u6539\u5bc6\u7801");
                label5.setFont(new Font("\u6977\u4f53", Font.BOLD, 25));
                panel2.add(label5);
                label5.setBounds(new Rectangle(new Point(175, 10), label5.getPreferredSize()));

                //---- label6 ----
                label6.setText("\u8f93\u5165\u5bc6\u7801");
                label6.setFont(new Font("\u6977\u4f53", Font.PLAIN, 20));
                panel2.add(label6);
                label6.setBounds(new Rectangle(new Point(70, 70), label6.getPreferredSize()));

                //---- label7 ----
                label7.setText("\u786e\u5b9a\u5bc6\u7801");
                label7.setFont(new Font("\u6977\u4f53", Font.PLAIN, 20));
                panel2.add(label7);
                label7.setBounds(new Rectangle(new Point(70, 120), label7.getPreferredSize()));

                //---- button2 ----
                button2.setText("\u786e\u5b9a");
                button2.setFont(new Font("\u6977\u4f53", Font.BOLD, 18));
                button2.setForeground(Color.white);
                button2.setBackground(new Color(0, 204, 204));
                panel2.add(button2);
                button2.setBounds(115, 220, 245, 30);

                //---- label8 ----
                label8.setFont(new Font("\u6977\u4f53", Font.PLAIN, 15));
                label8.setForeground(Color.red);
                panel2.add(label8);
                label8.setBounds(325, 120, 145, 20);

                //---- label9 ----
                label9.setFont(new Font("\u6977\u4f53", Font.BOLD, 15));
                label9.setForeground(Color.red);
                panel2.add(label9);
                label9.setBounds(325, 70, 145, 20);

                //---- passwordField2 ----
                passwordField2.setFont(new Font("\u6977\u4f53", Font.PLAIN, 14));
                panel2.add(passwordField2);
                passwordField2.setBounds(165, 65, 140, 30);

                //---- passwordField3 ----
                passwordField3.setFont(new Font("\u6977\u4f53", Font.PLAIN, 14));
                panel2.add(passwordField3);
                passwordField3.setBounds(165, 115, 140, 30);

                //---- label10 ----
                label10.setText("\u8f93\u5165\u9a8c\u8bc1");
                label10.setFont(new Font("\u6977\u4f53", Font.PLAIN, 20));
                panel2.add(label10);
                label10.setBounds(new Rectangle(new Point(70, 170), label10.getPreferredSize()));
                panel2.add(textField1);
                textField1.setBounds(165, 170, 140, 30);

                //---- label11 ----
                label11.setIcon(new ImageIcon("D:\\C++\u4ee3\u7801\u6587\u4ef6\\onlineshop\\resources\\clarifyImg.gif"));
                label11.setDoubleBuffered(true);
                panel2.add(label11);
                label11.setBounds(325, 175, 85, 25);
                panel2.add(textArea1);
                textArea1.setBounds(new Rectangle(new Point(385, 165), textArea1.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel2);
            panel2.setBounds(0, 0, 485, 270);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 490, 270);

        contentPane.setPreferredSize(new Dimension(490, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        Container pane = getContentPane();
        setVisible(true);
        pane.add(panel1);
        panel1.setVisible(true);
        pane.add(panel2);
        panel2.setVisible(false);

        String message = "您好，" + username + "!";
        label2.setText(message);
        label2.setSize(200, 20);
        label4.setSize(200, 20);
        passwordField1.setSize(200, 20);
        passwordField1.setEchoChar('*');
        passwordField2.setEchoChar('*');
        passwordField3.setEchoChar('*');


        passwordField1.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {
                        passwordField1.setText("");
                        label4.setText("");
                    }

                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {
                        String pass=new String(passwordField1.getPassword());
                        if (pass.length() == 0) {
                            label4.setText("*密码不能为空");
                        } else if (pass.contains(" ")) {
                            label4.setText("*密码不能含有空格");
                        }
                    }
                }
        );
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try {
                            if (ChangePasswordJDBC.checkPassword(username, passwordField1.getPassword())) {
                                panel1.setVisible(false);
                                panel2.setVisible(true);
                            } else {
                                System.out.println(passwordField1.getPassword());
                                label4.setText("*密码错误");
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                }
        );

        passwordField2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                passwordField2.setText("");
                label9.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                if (passwordField2.getPassword().length == 0) {
                    label9.setText("*密码不能为空");
                } else if (new String(passwordField2.getPassword()).contains(" ")) {
                    label9.setText("*密码不能含有空格");
                }
            }
        });
        passwordField3.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {


                    }

                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {
                        passwordField3.setText("");
                    }

                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {

                    }
                }
        );

        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try {
                            if (new String(passwordField2.getPassword()).equals(new String(passwordField3.getPassword())) && textField1.getText().equals(code)) {
                                if (ChangePasswordJDBC.updatePassword(username, passwordField3.getPassword())) {

                                    label8.setText("更改成功");
                                    label8.setForeground(Color.green);
                                }
                            } else if (!textField1.getText().equals(code)) {
                                label8.setText("*验证码错误");
                            } else if (new String(passwordField2.getPassword()).equals(new String(passwordField3.getPassword()))) {
                                label8.setText("*密码不一致");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                }
        );
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JButton button1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JPasswordField passwordField1;
    private JPanel panel2;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton button2;
    private JLabel label8;
    private JLabel label9;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JLabel label10;
    private JTextField textField1;
    private JLabel label11;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private String username;
    private String code;

}
