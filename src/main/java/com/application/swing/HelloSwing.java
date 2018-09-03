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
import javax.swing.JToolBar;

/**
 * Java Swing  练习
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloSwing{
    
    private  static final int WIDTH = 600;
    
    private  static final int HEIGHT = 400;

    public static void main(String[] args) {
        //顶级容器
        JFrame jframe =new JFrame("Test Swing");
        //设置关闭按钮
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //设置窗口大小
        jframe.setSize(WIDTH, HEIGHT);
        //窗口居中
        jframe.setLocationRelativeTo(null);
        
        
        //添加菜单栏
        //addMenuBar(jframe);
        
        //添加容器组件
        addPanel(jframe);
        
        //添加工具栏
        addToolsBar(jframe);
        
        //显示窗口
        jframe.setVisible(true);
    }
    
    /**      
     * 添加工具栏  
     * @param jframe  JFrame对象为容器  
    */
    private static void addToolsBar(JFrame jframe) {
        JToolBar jtb = new JToolBar();
        
        JButton  saveButton = new JButton("保存");
        JButton  newFileButton = new JButton("新建");
        
        jtb.add(saveButton);
        jtb.addSeparator();
        jtb.add(newFileButton);
        
        BorderLayout bl = new BorderLayout();
        jframe.setLayout(bl);
        jframe.add("North",jtb);
        jframe.setVisible(true);
        
    }

    /**
     *   添加menu菜单栏
     * @param jframe   JFrame对象为容器
     */
    private static  void addMenuBar(JFrame jframe) {
        //菜单栏
        JMenuBar  menubar = new JMenuBar();
        jframe.setJMenuBar(menubar);
        
        JMenu  fileMenu = new JMenu("文件");
        
        JMenuItem openMenuItem = new JMenuItem("打开");
        JMenuItem saveMenuItem = new JMenuItem("保存");
        JMenuItem printMenuItem = new JMenuItem("打印");
        JMenuItem exitMenuItem = new JMenuItem("退出");
        
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        //分隔符
        fileMenu.addSeparator();  
        fileMenu.add(printMenuItem);
        fileMenu.addSeparator();  
        fileMenu.add(exitMenuItem);
        
        JMenu  editMenu = new JMenu("编辑");
        JMenu  viewMenu = new JMenu("视图");
        menubar.add(fileMenu);
        menubar.add(editMenu);
        menubar.add(viewMenu);
    }
    
    /**
     *  添加Panel容器   组件 
     * @param jframe JFrame对象为容器
     */
    private  static  void addPanel(JFrame jframe) {
        //中间容器
        JPanel jpanel = new JPanel();
        jframe.setContentPane(jpanel);
        
        //组件
        JButton subButton = new JButton("确定");  
        jpanel.add(subButton);
        JButton cancelButton = new JButton("取消");  
        jpanel.add(cancelButton);
    }
}
