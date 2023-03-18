package com.study.house.pojo;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/3/11 14:33
 * @Description:
 */
public class HouseCount {
    private String city;
    private Integer number;

    @Override
    public String toString() {
        return "HouseCount{" +
                "city='" + city + '\'' +
                ", number=" + number +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
