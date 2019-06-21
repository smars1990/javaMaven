package com.application.algorithm.douglas;

import lombok.Data;

@Data
public class ModelDTO {

    public ModelDTO(){}
    public ModelDTO(double latitude,double longitude,int index){
        this.latitude = latitude;
        this.longitude = longitude;
        this.index = index;
    }

    /**
     * "纬度", example = "23"
     */
    private double latitude;

    /**
     *  "经度", example = "106"
     */
    private double longitude;

    /**
     * 点所属的曲线的索引
     */
    private int index;

}
