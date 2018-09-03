/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 * 
 */
package com.application.yuyin.util;

import java.util.ResourceBundle;

/**
 * 获取语音配置文件工具类
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class PropertiesUtils{

    private static PropertiesUtils instance = null;

    private ResourceBundle resourceBundle = null;

    private PropertiesUtils() {
        // 加载百度语音配置文件
        resourceBundle = ResourceBundle.getBundle("bdyyApp");
    }

    public static PropertiesUtils getInstance() {
        if (instance == null) {
            instance = new PropertiesUtils();
        }
        return instance;
    }

    /**
     * 
     * 获取bdyyApp.properties 的value值
     * @param configKey String对象用于bdyyApp文件的key键
     * @return String 返回bdyyApp文件的key键的value值
     */
    public String getProperties(String configKey) {

        // 获取bdyyApp的value值
        String str = resourceBundle.getString(configKey);

        // 返回bdyyApp的value值
        return str;
    }
}
