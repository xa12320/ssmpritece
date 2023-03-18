package com.study.house.dao;

import com.study.house.pojo.*;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 获取房子关注人数量
     * @return
     */
    List<HousePeople> getHousePeople();

    /**
     * 获取房子关注数量
     * @return
     */
    List<HouseCount> getHouseCount();

    /**
     * 获取房子优势信息
     * @return
     */
    List<HouseMerit> getHouseMerit();

    /**
     * 获取house的info
     * @return
     */
    List<String> getNorms(@Param("city") String city);

    /**
     * 通过城市获取数据
     * @param city
     * @return
     */
    List<Double> getHouseData(@Param("city") String city);

    /**
     * 获取城市
     * @return
     */
    List<String> getHOuseCity();

    /**
     * 查询面积地区的房子数量
     * @return
     */
    List<HouseArea> getHouseAreaCount();

    /**
     * 获取总房表的城市
     * @return
     */
    List<String> getHouseTotalCity();

    /**
     * 获取总房数量
     * @return
     */
    List<Integer> getHouseTotal();
}
