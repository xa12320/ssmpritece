package com.study.house.services.impl;

import com.study.house.dao.HouseDao;
import com.study.house.pojo.HouseInfo;
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
}
