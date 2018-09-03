/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Java Swing 练习 盒子布局
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloSwingBoxLayout{
    

    public static void main(String[] args) {
        BoxLayoutFrame boxLayoutFrame = new BoxLayoutFrame();
        boxLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boxLayoutFrame.setVisible(true);
        boxLayoutFrame.setLocationRelativeTo(null);
      
    }
    
}


class BoxLayoutFrame extends JFrame{

    /**    
     *  生成唯一序列号        
     */
    private static final long serialVersionUID = -6743338065832524337L;
    
    private  static final int WIDTH = 300;
    
    private  static final int HEIGHT = 200;
    
    
    public  BoxLayoutFrame() {
        
        //容器名称
        setTitle(" 测试箱式布局");
        //容器大小
        setSize(WIDTH,HEIGHT);
        
        //创建容器中间件
        Container container = getContentPane();
        
        //创建组件
        JLabel  userLabel = new  JLabel("姓名：");
        final JTextField userName = new JTextField(10);
        userName.setMaximumSize(userName.getPreferredSize());
        //创建一个水平箱子
        Box hbox = Box.createHorizontalBox();
        hbox.add(userLabel);
        hbox.add(Box.createHorizontalStrut(0));
        hbox.add(userName);
        
        //创建组件
        JLabel passLabel = new JLabel("密码：");
        final JTextField  password = new JTextField(10);
        password.setMaximumSize(password.getPreferredSize());
        //创建一个水平箱子
        Box hbox2 = Box.createHorizontalBox();
        hbox2.add(passLabel);
        hbox2.add(Box.createHorizontalStrut(0));
        hbox2.add(password);

        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                //判断用户名是否为空
                if(userName.getText().isEmpty()) {
                    userName.setText("请输入用户名...");
                }
                
                //判断密码是否为空
                if(password.getText().isEmpty()) {
                    password.setText("请输入密码...");
                }
                
            }
        });
        
        JButton cancelButton = new JButton("取消");
        cancelButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                //清除用户名和密码
                userName.setText("");
                password.setText("");
            }
        });
        
        //创建一个水平箱子
        Box hbox3 = Box.createHorizontalBox();
        hbox3.add(loginButton);
        hbox3.add(cancelButton);
        
        
        //创建竖行box 
        Box  vbox = Box.createVerticalBox();
        vbox.add(hbox);
        vbox.add(hbox2);
        vbox.add(hbox3);
       
         container.add(vbox, BorderLayout.CENTER);
        
        
    }
   
}
