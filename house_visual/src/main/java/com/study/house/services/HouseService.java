package com.study.house.services;

import com.study.house.pojo.*;

import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/25 14:59
 * @Description:
 */
public interface HouseService {

    List<HouseInfo> getHouseNum();

    List<HousePeople> getHousePeople();

    List<HouseCount> getHouseCount();

    List<HouseMerit> getHouseMerit();

    List<String> getNorms(String city);

    List<Double> getHouseData(String city);

    List<String> getHOuseCity();

    List<HouseArea> getHouseAreaCount();

    List<String> getHouseTotalCity();

    List<Integer> getHouseTotal();
}
