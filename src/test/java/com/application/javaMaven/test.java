/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.javaMaven;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.application.yuyin.util.PropertiesUtils;
import com.application.yuyin.util.YuYinUtils;

/**
 *  百度语音测试
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class test {

    public static void main(String[] args) throws Exception {

        PropertiesUtils propertiesUtils = PropertiesUtils.getInstance();

        String serverURL = propertiesUtils.getProperties("serverURL");
        String cuid = propertiesUtils.getProperties("cuid");
        String fileName = propertiesUtils.getProperties("fileName");
        String apiKey = propertiesUtils.getProperties("apiKey");
        String secretKey = propertiesUtils.getProperties("secretKey");

        // System.out.println("start zhong :"+ simpleDateFormat.format(new
        // Date()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
        System.out.println("start:" + simpleDateFormat.format(new Date()));

        String token = YuYinUtils.getToken(apiKey, secretKey);

        String configValue = YuYinUtils.method2(serverURL, token, cuid, fileName);

        System.out.println(configValue);

        System.out.println("end:" + simpleDateFormat.format(new Date()));

    }

}
