/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Java Swing 练习  流线布局
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloSwingFlowLayout2{

    /**
     * 宽度
     */
    private static final int WIDTH = 300;

    /**
     * 高度
     */
    private static final int HEIGHT = 200;

    private HelloSwingFlowLayout2() {
        // 创建JFrame 容器
        JFrame jframe = createJFrame();

        // 添加FlowLayout容器组件
        addPanel(jframe);

        // 显示窗口
        jframe.setVisible(true);
    }

    public static void main(String[] args) {
        new HelloSwingFlowLayout2();
    }

    /**
     * 创建JFrame容器
     * @return 返回swing容器
     */
    public JFrame createJFrame() {

        // 顶级容器
        JFrame jframe = new JFrame("Test Swing");
        // 设置关闭按钮
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口大小
        jframe.setSize(WIDTH, HEIGHT);
        // 窗口居中
        jframe.setLocationRelativeTo(null);

        return jframe;
    }

    /**
     * 添加Panel容器 组件
     * @param jframe JFrame对象为容器
     */
    public void addPanel(JFrame jframe) {
        // 中间容器
        JPanel jpanel = new JPanel();
        jframe.setContentPane(jpanel);

        // 布局管理器对象 FlowLayout
        jpanel.setLayout(new FlowLayout());

        // 添加borderLayout布局
        addBorderLayout(jframe);

        // 对流式布局 进行计算，选择合适大小窗口
        jframe.pack();

    }

    /**
     * 添加BorderLayout 信息
     * @param jbuttonList JButton对象集合
     * @param jframe JFrame对象为容器
     */
    private void addBorderLayout(JFrame jframe) {
        int i = 0;
        while (i <= 4) {
            // 组件
            JButton subButton1 = new JButton("生活1");
            JButton subButton2 = new JButton("工作2");
            JButton subButton3 = new JButton("购物3");
            JButton subButton4 = new JButton("饮食4");
            JButton subButton5 = new JButton("睡觉5");

            JPanel jpanel1 = new JPanel();
            BorderLayout bl1 = new BorderLayout();
            jpanel1.setLayout(bl1);

            jpanel1.add(subButton1, "North");
            jpanel1.add(subButton2, "South");
            jpanel1.add(subButton3, "East");
            jpanel1.add(subButton4, "West");
            jpanel1.add(subButton5, "Center");

            jframe.add(jpanel1);

            i++;
        }

    }

}
