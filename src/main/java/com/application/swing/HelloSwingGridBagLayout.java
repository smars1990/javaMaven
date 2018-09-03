/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

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
 * Java Swing 练习 网格布局
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloSwingGridBagLayout{

    /**
     * 宽度
     */
    private static  int WIDTH = 300;

    /**
     * 高度
     */
    private static  int HEIGHT = 200;

    private HelloSwingGridBagLayout() {
        // 创建JFrame 容器
        JFrame jframe = createJFrame();

        // 添加FlowLayout容器组件
        addPanel(jframe);

        // 显示窗口
        jframe.setVisible(true);
    }

    public static void main(String[] args) {
        new HelloSwingGridBagLayout();
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
        
        //布局管理器对象
        GridBagLayout bagLayout = new GridBagLayout();
        jpanel.setLayout(bagLayout);
        
        //设置顶层容器为居中
        Toolkit kit = Toolkit.getDefaultToolkit();   
        Dimension  screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width -WIDTH)/2;
        int y = (height - HEIGHT)/2;
        
        //设置窗口大小
        jframe.setLocation(x, y);
        
        JButton ok = new JButton("登陆");
        JButton cancel = new JButton("取消");
        
        JLabel title = new JLabel("欢迎登陆");
        JLabel userLabel= new JLabel("用户名");
        JLabel passLabel = new JLabel("密  码");
        
        JTextField userName = new JTextField(15);
        JTextField password = new JTextField(15);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weightx = 3;
        constraints.weighty = 4;
         
        add(jframe,title,constraints, 0,0,3,1);
        add(jframe,userLabel,constraints, 0,1,1,1);
        add(jframe,passLabel,constraints, 0,2,1,1);
        add(jframe,userName,constraints, 2,1,1,1);
        add(jframe,password,constraints, 2,2,1,1);
        add(jframe,ok,constraints, 0,3,1,1);
        add(jframe,cancel,constraints, 2,3,1,1);
    }
    
    /**
     *    添加控件到容器中
     * @param component
     * @param constraints
     * @param x
     * @param y
     * @param w
     * @param h
     */
    private void add(JFrame jframe,Component component, GridBagConstraints constraints,int x,int y, int w,int h) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        
        jframe.add(component,constraints);
    }
    
    
}
