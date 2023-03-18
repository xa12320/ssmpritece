package com.study.house.pojo;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/3/18 15:31
 * @Description:
 */
public class HouseTotal {
    private String city;
    private Integer total;

    @Override
    public String toString() {
        return "HouseTotal{" +
                "city='" + city + '\'' +
                ", total=" + total +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
