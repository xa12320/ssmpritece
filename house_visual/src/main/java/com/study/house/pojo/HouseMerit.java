package com.study.house.pojo;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/3/11 15:15
 * @Description:
 */
public class HouseMerit {
    private String city;
    private Double caiguang;
    private Double jiaotong;
    private Double dianti;
    private Double house;
    private Double fenjing;
    private Double shequ;

    @Override
    public String toString() {
        return city +
                "," + caiguang +
                "," + jiaotong +
                "," + dianti +
                "," + house +
                "," + fenjing +
                "," + shequ;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getCaiguang() {
        return caiguang;
    }

    public void setCaiguang(Double caiguang) {
        this.caiguang = caiguang;
    }

    public Double getJiaotong() {
        return jiaotong;
    }

    public void setJiaotong(Double jiaotong) {
        this.jiaotong = jiaotong;
    }

    public Double getDianti() {
        return dianti;
    }

    public void setDianti(Double dianti) {
        this.dianti = dianti;
    }

    public Double getHouse() {
        return house;
    }

    public void setHouse(Double house) {
        this.house = house;
    }

    public Double getFenjing() {
        return fenjing;
    }

    public void setFenjing(Double fenjing) {
        this.fenjing = fenjing;
    }

    public Double getShequ() {
        return shequ;
    }

    public void setShequ(Double shequ) {
        this.shequ = shequ;
    }
}
