/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Java Swing 练习 网格布局
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloSwingGridLayout{

    /**
     * 宽度
     */
    private static final int WIDTH = 300;

    /**
     * 高度
     */
    private static final int HEIGHT = 200;

    private HelloSwingGridLayout() {
        // 创建JFrame 容器
        JFrame jframe = createJFrame();

        // 添加FlowLayout容器组件
        addPanel(jframe);

        // 显示窗口
        jframe.setVisible(true);
    }

    public static void main(String[] args) {
        new HelloSwingGridLayout();
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

        // 组件
        JButton subButton1 = new JButton("生活");
        JButton subButton2 = new JButton("工作");
        JButton subButton3 = new JButton("购物");
        JButton subButton4 = new JButton("饮食");
        JButton subButton5 = new JButton("睡觉");
        
        //布局管理器对象
        jpanel.setLayout(new GridLayout(3, 1));
        
        jpanel.add(subButton1);
        jpanel.add(subButton2);
        jpanel.add(subButton3);
        jpanel.add(subButton4);
        jpanel.add(subButton5);
        
        
    }
}
