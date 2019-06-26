package com.application.location;

import com.alibaba.fastjson.JSONArray;
import com.application.location.dto.LocationEntity;
import com.application.location.util.PositionUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocationTest {
    public static void main(String[] args) {
        //坐标信息List集合
        List<LocationEntity> locationList = new ArrayList<>();

        double longitude = 110.625666;
        double latitude = 18.597227;

        double radius = 1000;

        //获取720个坐标，坐标稀疏距离为 0.5
        for( double  i = 0; i < 180;){
            i = i + 0.5;
            Map<String,Double> locationMap = PositionUtil.computerThatLonLat(longitude,latitude,i,radius);
            Double templatitude =  new BigDecimal( locationMap.get("latitude")).setScale(6, BigDecimal.ROUND_UP).doubleValue();
            Double tempLongitude = new BigDecimal( locationMap.get("longitude")).setScale(6, BigDecimal.ROUND_UP).doubleValue();
            LocationEntity locationEntity = new LocationEntity(templatitude,tempLongitude);
            locationList.add(locationEntity);
        }

        System.out.println(JSONArray.toJSON(locationList));


        //Map<String,Double> locationMap1 = PositionUtil.computerThatLonLat(longitude,latitude,0,radius);
        //System.out.println(locationMap1.toString());
        //{latitude=18.64239919248917, longitude=110.623213}

        //Map<String,Double> locationMap2 = PositionUtil.computerThatLonLat(longitude,latitude,180,radius);
        //System.out.println(locationMap2.toString());
        //{latitude=18.55205459117362, longitude=110.623213}
    }
}
