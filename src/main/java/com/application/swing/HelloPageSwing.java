/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Java Swing 标签页 练习
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloPageSwing extends JTabbedPane{

    /**
     * 生成唯一序列号
     */
    private static final long serialVersionUID = 8917201945013493000L;

    static final int WIDTH = 600;

    static final int HEIGHT = 400;

    private HelloPageSwing() {

        JFrame f = new JFrame("Java Swing  标签页");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 设置窗口大小
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension secreenSize = kit.getScreenSize();
        int width = secreenSize.width ;
        int height = secreenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        
        f.setLocationRelativeTo(null);
        f.setSize(x, y);
        
        JPanel p = new JPanel();
        f.setContentPane(p);
        f.setVisible(true);

        setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setLayout(new BorderLayout());
        addTab("panel1", panel1);
        setTitleAt(0, "测试页1");

        panel2.setLayout(new BorderLayout());
        addTab("panel2", panel2);
        setTitleAt(1, "测试页2");
        setEnabledAt(1, true);

        panel3.setLayout(new BorderLayout());
        addTab("panel3", panel3);
        setTitleAt(2, "测试页3");
        setEnabledAt(2, true);

        panel4.setLayout(new BorderLayout());
        addTab("panel4", panel4);
        setTitleAt(3, "测试页4");
        setEnabledAt(3, true);

        panel5.setLayout(new BorderLayout());
        addTab("panel5", panel5);
        setTitleAt(4, "测试页5");
        setEnabledAt(4, true);

        setPreferredSize(new Dimension(500, 200));
        setTabPlacement(JTabbedPane.TOP);
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        p.add("Center", this);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new HelloPageSwing();

    }
}
