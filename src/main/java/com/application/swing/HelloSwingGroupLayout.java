/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.swing;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Java Swing 练习 组布局
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloSwingGroupLayout{

    private static JFrame jFrame;

    /**
     * 宽度
     */
    private static final int WIDTH = 300;

    /**
     * 高度
     */
    private static final int HEIGHT = 200;
    
    private  HelloSwingGroupLayout() {
        
    }

    private HelloSwingGroupLayout(String fieldText) {

        jFrame = new JFrame(fieldText);
        jFrame.pack();

        // 设置JFrame
        setJFrame();

        // 创建 容器组件
        createContainer();

    }

    public static void main(String[] args) {
        new HelloSwingGroupLayout("记事本");
    }

    /**
     * 
     * 设置JFrame
     */
    public static void setJFrame() {
        // 关闭程序是，服务自动停止
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置宽度、高度
        jFrame.setSize(WIDTH, HEIGHT);
        // 设置位置
        jFrame.setLocationRelativeTo(null);
        // 显示
        jFrame.setVisible(true);

    }

    /**
     * 创建 容器组件
     */
    public static void createContainer() {
        // 创建一个新的中间容器
        Container container = jFrame.getContentPane();

        // 创建一个布局
        GroupLayout groupLayout = new GroupLayout(container);

        // 创建组件
        final JTextArea jTextField = new JTextArea(20, 30);
        // 设置字体
        jTextField.setFont(new Font(null, 12, 18));
        // 换行
        jTextField.setLineWrap(true);
        
        JButton jButton1 = new JButton("确定");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String textValue = jTextField.getText();
                System.out.println(textValue);
            }
        });

        JButton jButton2 = new JButton("清除");
        jButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
            }
        });

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.add(jTextField);
        
        
        
        // 创建hsg组，并把组件放到组里面
        GroupLayout.SequentialGroup hsg = groupLayout.createSequentialGroup();
        hsg.addComponent(jButton1);
        hsg.addComponent(jButton2);

        // 创建hpg组，并将文本框和上面的 hsg组 放到其中，并且居中排列
        GroupLayout.ParallelGroup hpg = groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER);
        hpg.addComponent(jTextField).addGroup(hsg);

        // 沿水平线来确定hpg组中两个按钮组件的位置
        //groupLayout.setHorizontalGroup(hpg);
        
        

        // 创建vpg组，按照水平线来排列两个组件的位置
        GroupLayout.ParallelGroup vpg = groupLayout.createParallelGroup();
        vpg.addComponent(jButton1);
        vpg.addComponent(jButton2);

        // 创建vsg组，并将连个组件放 到其中，
        GroupLayout.SequentialGroup vsg = groupLayout.createSequentialGroup();
        vsg.addComponent(jTextField).addGroup(vpg);
        
        // 沿水平线来确定vsg，vpg 和文本框组件的位置
        //groupLayout.setVerticalGroup(vsg);

        jFrame.setLayout(groupLayout);

    }

}
