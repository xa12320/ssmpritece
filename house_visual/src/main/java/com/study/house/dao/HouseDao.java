package com.study.house.dao;

import com.study.house.pojo.HouseInfo;

import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/25 15:01
 * @Description:
 */
public interface HouseDao {

    /**
     * 查询
     * @return
     */
    List<HouseInfo> getHouseInfo();
}
