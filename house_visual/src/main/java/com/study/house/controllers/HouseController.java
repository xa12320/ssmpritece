package com.study.house.controllers;

import com.study.house.pojo.HouseInfo;
import com.study.house.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/25 14:47
 * @Description:
 */
@Controller
public class HouseController {

    @Autowired
    private HouseService houseService;



    @RequestMapping("/houseinfo")
    @ResponseBody
    public Map getHouseInfo(){
        List<HouseInfo> houseInfos = houseService.getHouseNum();

        Map<String,Object> map = new HashMap<>();
        ArrayList<String> infos = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();
        int i = 0;
        for (HouseInfo info : houseInfos) {
            if("上海".equals(info.getCity())){
                list1.add(info.getNumber());
                infos.add(info.getHouseInfo());
            }
            if("北京".equals(info.getCity())){
                list2.add(info.getNumber());
            }
            if("广州".equals(info.getCity())){
                list3.add(info.getNumber());
            }
            if("深圳".equals(info.getCity())){
                list4.add(info.getNumber());
            }
            i++;
        }
        String[] citys = new String[]{"上海","北京","广州","深圳"};
        map.put("sh", list1);
        map.put("bj", list2);
        map.put("gz", list3);
        map.put("sz", list4);
        map.put("infos", infos);
        map.put("citys", citys);
        return map;
    }

}
