package com.study.house.services.impl;

import com.study.house.dao.HouseDao;
import com.study.house.pojo.*;
import com.study.house.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/25 15:00
 * @Description:
 */
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;


    @Override
    public List<HouseInfo> getHouseNum() {
        return houseDao.getHouseInfo();
    }

    @Override
    public List<HousePeople> getHousePeople() {
        return houseDao.getHousePeople();
    }

    @Override
    public List<HouseCount> getHouseCount() {
        return houseDao.getHouseCount();
    }

    @Override
    public List<HouseMerit> getHouseMerit() {
        return houseDao.getHouseMerit();
    }

    @Override
    public List<String> getNorms(String city) {
        return houseDao.getNorms(city);
    }

    @Override
    public List<Double> getHouseData(String city) {
        return houseDao.getHouseData(city);
    }

    @Override
    public List<String> getHOuseCity() {
        return houseDao.getHOuseCity();
    }

    @Override
    public List<HouseArea> getHouseAreaCount() {
        return houseDao.getHouseAreaCount();
    }

    @Override
    public List<String> getHouseTotalCity() {
        return houseDao.getHouseTotalCity();
    }

    @Override
    public List<Integer> getHouseTotal() {
        return houseDao.getHouseTotal();
    }
}
