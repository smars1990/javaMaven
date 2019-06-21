package com.application.location.dto;


public class LocationEntity {

    /**
     * 垂直方向值/纬度
     */
    private Double longitude;//p

    /**
     * 水平方向值/经度
     */
    private Double latitude;//o

    public LocationEntity() {
    }

    public LocationEntity(Double latitude, Double longitude) {
        latitude = latitude == null ? 0 : latitude;
        longitude = longitude == null ? 0 : longitude;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


    @Override
    public boolean equals(Object obj) {


        // 如果为同一对象的不同引用,则相同
        if (this == obj) {
            return true;
        }
        // 如果传入的对象为空,则返回false
        if (obj == null) {
            return false;
        }
        if (obj instanceof LocationEntity) {
            LocationEntity location = (LocationEntity) obj;
            if (location.latitude.equals(this.latitude) && location.longitude.equals(this.longitude)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
