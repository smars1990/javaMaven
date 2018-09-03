/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.yuyin.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

/**
 *  百度语音工具类
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class YuYinUtils{
  
//    /**
//     * 
//     * 获取百度语音读取信息 ：  通过url访问发送JSON信息
//     * @param serverURL   String对象用于访问
//     * @param token
//     * @param cuid
//     * @param fileName
//     * @return
//     * @throws Exception
//     */
//    public static  String  method1(String serverURL,String token,String cuid,String  fileName) throws Exception {
//        File pcmFile = new File(fileName);
//        HttpURLConnection conn = (HttpURLConnection) new URL(serverURL).openConnection();
//
//        // construct params
//        JSONObject params = new JSONObject();
//        params.put("format", "pcm");
//        params.put("rate", 8000);
//        params.put("channel", "1");
//        params.put("token", token);
//        params.put("cuid", cuid);
//        params.put("len", pcmFile.length());
//        params.put("speech", DatatypeConverter.printBase64Binary(loadFile(pcmFile)));
//
//        // add request header
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
//
//        conn.setDoInput(true);
//        conn.setDoOutput(true);
//
//        // send request
//        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
//        wr.writeBytes(params.toString());
//        wr.flush();
//        wr.close();
//
//         return printResponse(conn);
//    }
    
    /**
     *  通过url访问发送pcm文件
     * @param fileName
     * @param token
     * @param serverURL
     * @param cuid
     * @return
     * @throws Exception
     */
    public  static String  method2(String fileName,String token,String serverURL,String cuid) throws Exception {
   
      
        HttpURLConnection  conn = getHttpConnection(fileName,serverURL,cuid,token);

        // send request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.write(loadFile(fileName));
        wr.flush();
        wr.close();

        return  printResponse(conn);
    }
    
    /**
     * 
     * 获取访问HttpURLConnection返回的数据  
     * @param conn HttpURLConnection对访问服务器对象链接
     * @return  返回 访问服务器返回的对象
     * @throws Exception
     */
    public  static String printResponse(HttpURLConnection conn) throws Exception {
        if (conn.getResponseCode() != 200) {
            // request error
            return "";
        }
        InputStream is = conn.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }
    
    /**
     *  
     * 读取pcm格式音频文件
     * @param pcmFilePath  String对象为pcm格式音频文件路径
     * @return   返回读取的pcm格式音频文件的byte数组
     * @throws IOException
     */
    public  static byte[] loadFile(String  pcmFilePath) throws IOException {
        File file = new File(pcmFilePath);
        InputStream is = new FileInputStream(file);

        long length = file.length();
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            is.close();
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
    }
    
    /**
     *  
     * 获取百度语音access_ token
     * @param apiKey  String对象为百度语音appKey
     * @param secretKey   String对象为百度语音app secret
     * @return    返回访问百度语音token
     * @throws Exception  
     */
    public  static String  getToken(String apiKey,String secretKey) throws Exception {
        String getTokenURL = "https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials" + 
            "&client_id=" + apiKey + "&client_secret=" + secretKey;
        HttpURLConnection conn = (HttpURLConnection) new URL(getTokenURL).openConnection();
        String  token = new JSONObject(printResponse(conn)).getString("access_token");
        
        return token;
    }
    
    
    /**
     * 
     *获取HttpURLConnection 链接对象 
     * @param fileName  String对象为 pcm音频格式文件路径
     * @param serverURL   String 对象为访问百度语音服务URL路径
     * @param cuid     String对象为百度语音app Id
     * @param token   String对象为访问百度语音token
     * @return   返回HttpURLConnection链接对象
     * @throws Exception
     */
    public  static  HttpURLConnection  getHttpConnection(String fileName,String serverURL,String cuid,String token) throws Exception {
   
        HttpURLConnection conn = (HttpURLConnection) new URL(serverURL
                + "?cuid=" + cuid + "&token=" + token).openConnection();

        // add request header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "audio/pcm; rate=8000");

        conn.setDoInput(true);
        conn.setDoOutput(true);
        
        return  conn;
    }
    
}
