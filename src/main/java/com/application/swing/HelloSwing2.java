/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Java Swing 练习
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloSwing2{

    /**
     * 宽度
     */
    private static final int WIDTH = 600;

    /**
     * 高度
     */
    private static final int HEIGHT = 400;

    private HelloSwing2() {
        // 创建JFrame 容器
        JFrame jframe = createJFrame();

        // 添加菜单栏
        addMenuBar(jframe);

        // 添加容器组件
        addPanel(jframe);

        // 显示窗口
        jframe.setVisible(true);
    }

    public static void main(String[] args) {
        new HelloSwing2();
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
        JButton subButton = new JButton("确定");
        jpanel.add(subButton);
        JButton cancelButton = new JButton("取消");
        jpanel.add(cancelButton);
    }
}
