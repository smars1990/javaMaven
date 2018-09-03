/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Java Swing 练习 卡片布局
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloSwingCardLayout extends JFrame{

    /**    
     *  生成唯一序列号     
     */
    private static final long serialVersionUID = 3074558117624579091L;

    private JPanel panel = null; // 按钮放置的panel

    // card放置的panel
    private JPanel p = null;

    // CardLayout 卡片布局管理器
    private CardLayout cardLayout = null;

    // 上一步
    private JButton bt1 = null;

    // 下一步
    private JButton bt2 = null;

    // 三个可以直接切换到Panel 组件的按钮
    private JButton b_1 = null, b_2 = null, b_3 = null;

    // 三个可以切换的JPanel
    private JPanel p_1 = null, p_2 = null, p_3 = null;

    private HelloSwingCardLayout() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
          super("CardLayout Test");
          
        // 设置window 样式
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        // 创建一个具有一定水平的卡片显示
        cardLayout = new CardLayout(5, 5);

        panel = new JPanel();
        p = new JPanel();

        bt1 = new JButton("<上一步");
        bt2 = new JButton("下一步>");
        b_1 = new JButton("1");
        b_2 = new JButton("2");
        b_3 = new JButton("3");
        b_1.setMargin(new Insets(2, 2, 2, 2));
        b_2.setMargin(new Insets(2, 2, 2, 2));
        b_3.setMargin(new Insets(2, 2, 2, 2));
        p.add(bt1);
        p.add(b_1);
        p.add(b_2);
        p.add(b_3);
        p.add(bt2);

        p_1 = new JPanel();
        p_2 = new JPanel();
        p_3 = new JPanel();
        p_1.setBackground(Color.RED);
        p_2.setBackground(Color.BLUE);
        p_3.setBackground(Color.GRAY);
        p_1.add(new JLabel("JPanel1"));
        p_2.add(new JLabel("JPanel2"));
        p_3.add(new JLabel("JPanel3"));
        panel.add(p_1, "p_1");
        panel.add(p_2, "p_2");
        panel.add(p_3, "p_3");

        // 翻动 卡片 监听
        bt1.addActionListener(new ActionListener() {
            //上一步
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(panel);
            }
        });
        
        bt2.addActionListener(new ActionListener() {
           //下一步
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(panel);
            }
        });
        
        b_1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "p_1");
            }
        });

        b_2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "p_2");
            }
        });

        b_3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "p_3");
            }
        });
        
        this.getContentPane().add(panel);
        this.getContentPane().add(p,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);
        this.setVisible(true);
    }
    
    public static void main(String[] args) throws Exception{
         HelloSwingCardLayout  helloSwingCardLayout = new HelloSwingCardLayout();
    }

}
