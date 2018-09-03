/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Java Swing 登录窗口 练习
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloWindowSwing extends JPanel{

    /**
     * Generate unique serial Numbers
     */
    private static final long serialVersionUID = -7038439480786721902L;

    /**
     * width
     */
    static final int WIDTH = 300;

    /**
     * height
     */
    static final int HEIGHT = 150;

    /**
     * 登录窗口 frame
     */
    JFrame loginFrame;

    /**
     * 按照网络布局方式排列组件
     * @param component 控件(中间件)
     * @param constraints
     * @param x String对象用于控件位于第几列
     * @param y String对象用于控件位于第几行
     * @param w String对象用于控件需要占几列
     * @param h String对象用于控件需要占几行
     */
    public void add(Component component, GridBagConstraints constraints, int x, int y, int w, int h) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;

        add(component, constraints);
    }

    public HelloWindowSwing() {

        loginFrame = new JFrame("登录窗口测试");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置窗口内容
        JButton login = new JButton("登录");
        JButton cancel = new JButton("取消");
        JLabel titile = new JLabel("欢迎登录");
        JLabel name = new JLabel("用户名");
        JLabel password = new JLabel("密码");
        final JTextField nameInput = new JTextField(15);
        final JTextField passwordInput = new JTextField(15);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weightx = 3;
        constraints.weighty = 4;

        add(titile, constraints, 0, 0, 4, 1);
        add(name, constraints, 0, 1, 1, 1);
        add(password, constraints, 0, 2, 1, 1);
        add(nameInput, constraints, 2, 1, 1, 1);
        add(passwordInput, constraints, 2, 2, 1, 1);
        add(login, constraints, 0, 3, 1, 1);
        add(cancel, constraints, 2, 3, 1, 1);

        // 设置布局类型
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        loginFrame.add(this, BorderLayout.EAST);
        loginFrame.setSize(WIDTH, HEIGHT);

        // 设置窗口大小
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension secreenSize = kit.getScreenSize();
        int width = secreenSize.width;
        int height = secreenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        loginFrame.setLocation(x, y);

        //loginFrame.setResizable(false);
        loginFrame.setVisible(true);

    }

    public static void main(String[] agrs) {
        HelloWindowSwing helloSwing = new HelloWindowSwing();
    }

}
