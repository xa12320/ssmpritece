package com.study.house.pojo;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/3/11 16:24
 * @Description:
 */
public class HouseNorms {
    private String city;
    private String info;
    private Double num;

    @Override
    public String toString() {
        return "HouseNorms{" +
                "city='" + city + '\'' +
                ", info='" + info + '\'' +
                ", num=" + num +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }
}
