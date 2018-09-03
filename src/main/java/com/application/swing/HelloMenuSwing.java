/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

/**
 * Java Swing 菜单栏 练习
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloMenuSwing extends JPanel{

    /**
     * 生成唯一序列号
     */
    private static final long serialVersionUID = -7106284428401974995L;

    static final int WIDTH = 600;

    static final int HEIGHT = 400;

    public JFrame jFrame;

    JPopupMenu pop;

    JFrame f;

    JPanel p;

    JToolBar bar;

    public HelloMenuSwing() {
        f = new JFrame("我的测试界面");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置menu菜单
        JMenuBar menuBar = new JMenuBar();
        p = new JPanel();
        f.setContentPane(p);
        f.setJMenuBar(menuBar);
        JMenu menu1 = new JMenu("菜单1");
        JMenu menu2 = new JMenu("菜单2");
        JMenu menu3 = new JMenu("菜单3");
        JMenu menu4 = new JMenu("菜单4");
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);

        JMenuItem item1 = new JMenuItem(" 子菜单1");
        JMenuItem item2 = new JMenuItem(" 子菜单2");
        JMenuItem item3 = new JMenuItem("子菜单3");
        JMenuItem item4 = new JMenuItem("子菜单4");
        JMenuItem item5 = new JMenuItem("子菜单5");
        JMenuItem item6 = new JMenuItem("子菜单6");
        JMenuItem item7 = new JMenuItem("子菜单7");
        JMenuItem item8 = new JMenuItem("子菜单8");
        JMenuItem item9 = new JMenuItem("子菜单9");
        JMenuItem item10 = new JMenuItem("子菜单10");
        JMenuItem item11 = new JMenuItem("子菜单11");
        JMenuItem item12 = new JMenuItem("子菜单12");
        JMenuItem item13 = new JMenuItem("子菜单13");

        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(item2);
        menu1.addSeparator();
        menu1.add(item3);
        menu1.addSeparator();
        menu1.add(item4);
        menu1.addSeparator();
        menu2.add(item5);
        menu2.addSeparator();
        menu2.add(item6);
        menu2.addSeparator();
        menu2.add(item7);
        menu2.addSeparator();
        menu2.add(item8);
        menu2.addSeparator();
        menu3.add(item9);
        menu3.addSeparator();
        menu3.add(item10);
        menu3.addSeparator();
        menu3.add(item11);
        menu3.addSeparator();
        menu4.add(item12);
        menu4.addSeparator();
        menu4.add(item13);
        menu4.addSeparator();

        // 设置工具栏
        JButton jbutton1 = new JButton("工具1");
        JButton jbutton2 = new JButton("工具2");
        JButton jbutton3 = new JButton("工具3");
        bar = new JToolBar();
        bar.add(jbutton1);
        bar.add(jbutton2);
        bar.add(jbutton3);

        // 设置布局类型
        BorderLayout bord = new BorderLayout();
        p.setLayout(bord);
        p.add("North", bar);
        f.setVisible(true);
        f.setSize(WIDTH, HEIGHT);

        // 设置窗口大小
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int heigth = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (heigth - HEIGHT) / 2;
        f.setLocation(x, y);

    }

    public static void main(String[] args) {

        HelloMenuSwing helloWorldSwing = new HelloMenuSwing();

    }

}
