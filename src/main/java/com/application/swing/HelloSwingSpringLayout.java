/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import sun.font.CreatedFontTracker;

/**
 * Java Swing 练习 边距布局
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloSwingSpringLayout{

    private static final int WIDTH = 300;

    private static final int HEIGHT = 200;

    private static JFrame jFrame = null;

    public static void main(String[] args) {

        jFrame = createJFrame();
        
        
        createJPanelContion();

        jFrame.setVisible(true);

    }

    /**
     * 创建JFrame
     * @return 返回JFrame
     */
    public static JFrame createJFrame() {
        jFrame = new JFrame("SpringLayout 测试");
        // 关闭窗口时，主程序关闭
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 窗口居中
        jFrame.setLocationRelativeTo(null);
        // 设置窗口大小
        jFrame.setSize(WIDTH, HEIGHT);

        return jFrame;
    }

    /**
     * 
     * 创建内容组件
     */
    public static void createJPanelContion() {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        final JLabel jLabel = new JLabel("测试程序");
        JButton jbutton1 = new JButton("测试程序模块1");
        jbutton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jLabel.setText("测试程序模块1");
            }
        });
        JButton jbutton2 = new JButton("测试程序模块2");
        jbutton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jLabel.setText("测试程序模块2");
            }
        });

        jPanel.add(jLabel);
        jPanel.add(jbutton1);
        jPanel.add(jbutton2);

        // 创建SpringLayout 布局
        SpringLayout springLayout = new SpringLayout();
        jPanel.setLayout(springLayout);

        springLayout.putConstraint(SpringLayout.NORTH, jLabel, 5, SpringLayout.NORTH, jPanel);
        springLayout.putConstraint(SpringLayout.EAST, jLabel, 85, SpringLayout.EAST, jPanel);
        springLayout.putConstraint(SpringLayout.WEST, jLabel, 85, SpringLayout.WEST, jPanel);

        springLayout.putConstraint(SpringLayout.NORTH, jbutton1, 55, SpringLayout.NORTH, jPanel);
        springLayout.putConstraint(SpringLayout.EAST, jbutton1, 5, SpringLayout.EAST, jPanel);
        springLayout.putConstraint(SpringLayout.WEST, jbutton1, 25, SpringLayout.WEST, jPanel);

        springLayout.putConstraint(SpringLayout.NORTH, jbutton2, 105, SpringLayout.NORTH, jPanel);
        springLayout.putConstraint(SpringLayout.EAST, jbutton2, 5, SpringLayout.EAST, jPanel);
        springLayout.putConstraint(SpringLayout.WEST, jbutton2, 25, SpringLayout.WEST, jPanel);

    }

}
