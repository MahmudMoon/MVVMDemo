package com.example.moon.mvvmdemo.models;

public class NicePlaceInfo {
    String placeName;
    String placeImageUrl;

    public NicePlaceInfo(String placeName, String placeImageUrl) {
        this.placeName = placeName;
        this.placeImageUrl = placeImageUrl;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceImageUrl() {
        return placeImageUrl;
    }

    public void setPlaceImageUrl(String placeImageUrl) {
        this.placeImageUrl = placeImageUrl;
    }
}
