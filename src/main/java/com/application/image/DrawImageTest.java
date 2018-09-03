package com.application.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import sun.misc.BASE64Encoder;

public class DrawImageTest {

	
	public static void main(String[] args) throws Exception {
		
        InputStream in = new FileInputStream("E:\\demoImg\\111.160.74.154_01_20180818141708473_TIMING.jpg");
        
        BufferedImage bufferImage = ImageIO.read( in);
        Graphics g = bufferImage.getGraphics();
        //画笔颜色
        g.setColor(Color.RED);
        

        //矩形框(原点x坐标，原点y坐标，矩形的长，矩形的宽)
        g.drawRect(300, 450, 140, 390);
        
        //矩形框(原点x坐标，原点y坐标，矩形的长，矩形的宽)
        g.drawRect(347, 440, 292, 340);
        
        // 结束
        g.dispose();
        
       //输出图片的地址
        FileOutputStream out = new FileOutputStream("d:\\test2.jpg");
        ImageIO.write(bufferImage, "jpeg", out);
        
        //把图片转换成 byte数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferImage, "jpeg", baos);
        byte[] bytes = baos.toByteArray();
        
        //再把数组转换成BASE64字符串， 在加上图片的格式
        BASE64Encoder  base64Encoder = new BASE64Encoder();
        String  base64Str = base64Encoder.encode(bytes);
        
        String imageFile = "data:image/"+"jpeg"+";base64,"+base64Str;
        
        System.out.println(imageFile);      
	}
	
	
}
