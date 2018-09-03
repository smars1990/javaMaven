/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Java Swing 练习 流线布局
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloSwingBorderLayout2{

    /**
     * 宽度
     */
    private static final int WIDTH = 600;

    /**
     * 高度
     */
    private static final int HEIGHT = 400;

    private HelloSwingBorderLayout2() {
        // 创建JFrame 容器
        JFrame jframe = createJFrame();

        // 添加菜单栏
       //addMenuBar(jframe);

        // 添加容器组件
        addPanel(jframe);

        // 显示窗口
        jframe.setVisible(true);
    }

    public static void main(String[] args) {
        new HelloSwingBorderLayout2();
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
     * 添加menu菜单栏
     * @param jframe JFrame对象为容器
     */
    public void addMenuBar(JFrame jframe) {
        // 菜单栏
        JMenuBar menubar = new JMenuBar();
        jframe.setJMenuBar(menubar);

        JMenu fileMenu = new JMenu("文件");

        JMenuItem openMenuItem = new JMenuItem("打开");
        JMenuItem saveMenuItem = new JMenuItem("保存");
        JMenuItem printMenuItem = new JMenuItem("打印");
        JMenuItem exitMenuItem = new JMenuItem("退出");

        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        // 分隔符
        fileMenu.addSeparator();
        fileMenu.add(printMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        JMenu editMenu = new JMenu("编辑");
        JMenu viewMenu = new JMenu("视图");
        menubar.add(fileMenu);
        menubar.add(editMenu);
        menubar.add(viewMenu);
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
        JButton subButton1 = new JButton("港币");
        JButton subButton2 = new JButton("人民币");
        JButton subButton3 = new JButton("美元");
        JButton subButton4 = new JButton("欧元");
        JButton subButton5 = new JButton("英镑");
        JButton subButton6 = new JButton("主板");
        JButton subButton7 = new JButton("内存条");
        JButton subButton8 = new JButton("显卡");
        JButton subButton9 = new JButton("机箱");
        JButton subButton10 = new JButton("电源");
        JButton subButton11 = new JButton("大米");
        JButton subButton12 = new JButton("蔬菜");
        JButton subButton13 = new JButton("肉制品");
        JButton subButton14 = new JButton("豆制品");
        JButton subButton15 = new JButton("面粉");
        
        jframe.setLayout(new BorderLayout());
        
        //创建3个布局管理器
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        
        jPanel1.setLayout(new BorderLayout());
        jPanel2.setLayout(new BorderLayout());
        jPanel3.setLayout(new BorderLayout());
        
        //把创建的三个容器 放置到不同的方位
        jpanel.add(jPanel1,"North");
        jpanel.add(jPanel2,"South");
        jpanel.add(jPanel3,"Center");
        
       
        jPanel1.add(subButton1, "South");
        jPanel1.add(subButton2, "North");
        jPanel1.add(subButton3, "West");
        jPanel1.add(subButton4, "East");
        jPanel1.add(subButton5, "Center");
        
        jPanel2.add(subButton6, "South");
        jPanel2.add(subButton7, "North");
        jPanel2.add(subButton8, "East");
        jPanel2.add(subButton9, "West");
        jPanel2.add(subButton10, "Center");
        
        jPanel3.add(subButton11, "South");
        jPanel3.add(subButton12, "North");
        jPanel3.add(subButton13, "East");
        jPanel3.add(subButton14, "West");
        jPanel3.add(subButton15, "Center");
        


    }
}
