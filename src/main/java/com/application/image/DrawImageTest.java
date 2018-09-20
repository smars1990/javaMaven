package com.application.image;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Encoder;

public class DrawImageTest {

	
	@SuppressWarnings("restriction")
	public static void main(String[] args) throws Exception {
		String imagePath = "E:\\邮件签名2.png";
		
/*		if( imagePath.contains("/") ) {
			System.out.println("转换前："+imagePath);
			//imagePath.replace("/", "\\\\");
			imagePath = imagePath.replaceAll("/","\\\\");
			
			//StringUtils.replaceAll(imagePath,"\\\\", "/" );
			System.out.println("转换后："+imagePath);
		}*/
	
		
		
		
/*		String path = "D:\\FTP\\admin\\bird.gif";//文件路径，双斜杠输出的是一个斜杠

		System.out.println(path);//打印路径

		//JAVA中正则表达式,用"\\\\"表示"\"

		path = path.replaceAll("\\\\", "/");

		System.out.println(path);//打印路径
*/
		
		
		
        InputStream in = new FileInputStream(imagePath);
        
        BufferedImage bufferImage = ImageIO.read( in);
        Graphics g = bufferImage.getGraphics();
        
        //画笔颜色
        g.setColor(Color.RED);
        


    	// 将基本的绘图强转为2D绘图
		Graphics2D g2d = (Graphics2D) g;
		// 加粗
		g2d.setStroke(new BasicStroke(4f));

		// 画笔颜色
		g2d.setColor(Color.decode("#FE0202"));
        
        
       // (243.0,341.0),(215.0,309.0)

        //矩形框(原点x坐标，原点y坐标，矩形的长，矩形的宽)
		//g2d.drawRect(215, 309, 243-215, 341-309);
        
        //矩形框(原点x坐标，原点y坐标，矩形的长，矩形的宽)
        //g.drawRect(347, 440, 292, 340);
        
        // 结束
		g2d.dispose();
        
       //输出图片的地址
        FileOutputStream out = new FileOutputStream("C:\\Users\\liuyunpeng\\Desktop\\test2.jpg");
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
