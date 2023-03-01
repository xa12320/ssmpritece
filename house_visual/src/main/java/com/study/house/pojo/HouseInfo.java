package com.study.house.pojo;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/25 16:32
 * @Description:
 */
public class HouseInfo {
    private Integer id;
    private String city;
    private String houseInfo;
    private Integer number;

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", houseInfo='" + houseInfo + '\'' +
                ", number=" + number +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
