package com.study.house.pojo;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/3/18 14:31
 * @Description:
 */
public class HouseArea {
    private String city;
    private String fanwei;
    private Integer num;

    @Override
    public String toString() {
        return "HouseArea{" +
                "city='" + city + '\'' +
                ", fanwei='" + fanwei + '\'' +
                ", num=" + num +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFanwei() {
        return fanwei;
    }

    public void setFanwei(String fanwei) {
        this.fanwei = fanwei;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
