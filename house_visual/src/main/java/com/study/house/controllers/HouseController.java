package com.study.house.controllers;

import com.study.house.pojo.*;
import com.study.house.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/25 14:47
 * @Description:
 */
@Controller
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping("/total")
    @ResponseBody
    public Map getTotalHouse(){
        Map<String,Object> map = new HashMap<>();
        List<String> list = houseService.getHouseTotalCity();
        List<Integer> number = houseService.getHouseTotal();
        map.put("citys", list);
        map.put("number", number);
        return map;
    }

    @RequestMapping("/area")
    @ResponseBody
    public Map getHouseAreaCount(){
        Map<String,Object> map = new HashMap<>();
        List<HouseArea> area = houseService.getHouseAreaCount();
        String[] city = {"上海","深圳"};
        List<String> scope = new ArrayList<>();
        List<Integer> numSh = new ArrayList<>();
        List<Integer> numSz = new ArrayList<>();
        for (HouseArea houseArea : area) {
            if("上海".equals(houseArea.getCity())){
                scope.add(houseArea.getFanwei());
                numSh.add(houseArea.getNum());
            }
            if("深圳".equals(houseArea.getCity())){
                numSz.add(houseArea.getNum());
            }

        }
        map.put("citys", city);
        map.put("scope", scope);
        map.put("sh", numSh);
        map.put("sz", numSz);
        return map;
    }

    @RequestMapping("/houseNorms")
    @ResponseBody
    public Map getHouseNorms(){
        Map<String,Object> map = new HashMap<>();
        List<String> cityList = houseService.getHOuseCity();
        List<String> infoList = null;
        List<Double> dataSH = null;
        List<Double> dataBJ = null;
        List<Double> dataGZ = null;
        List<Double> dataSZ = null;
        for (String s : cityList) {
            if("上海".equals(s)){
                infoList = houseService.getNorms(s);
                dataSH = houseService.getHouseData(s);
            }else if("北京".equals(s)){
                dataBJ = houseService.getHouseData(s);
            }else if("广州".equals(s)){
                dataGZ = houseService.getHouseData(s);
            }else if("深圳".equals(s)){
                dataSZ = houseService.getHouseData(s);
            }
        }
        map.put("citys", cityList);
        map.put("info", infoList);
        map.put("sh", dataSH);
        map.put("bj", dataBJ);
        map.put("gz", dataGZ);
        map.put("sz", dataSZ);
        return map;
    }

    @RequestMapping("/houseMerit")
    @ResponseBody
    public Map getHouseMerit(){
        Map<String,Object> map = new HashMap<>();
        //获取房子优势信息
        List<HouseMerit> houseMerit = houseService.getHouseMerit();
        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();
        List<Object> list4 = new ArrayList<>();
        for (HouseMerit merit : houseMerit) {
            switch (merit.getCity()){
                case "上海":
                    list1.add(merit.getCity());
                    list1.add(merit.getCaiguang());
                    list1.add(merit.getJiaotong());
                    list1.add(merit.getDianti());
                    list1.add(merit.getHouse());
                    list1.add(merit.getFenjing());
                    list1.add(merit.getShequ());
                    break;
                case "北京":
                    list2.add(merit.getCity());
                    list2.add(merit.getCaiguang());
                    list2.add(merit.getJiaotong());
                    list2.add(merit.getDianti());
                    list2.add(merit.getHouse());
                    list2.add(merit.getFenjing());
                    list2.add(merit.getShequ());
                    break;
                case "广州":
                    list3.add(merit.getCity());
                    list3.add(merit.getCaiguang());
                    list3.add(merit.getJiaotong());
                    list3.add(merit.getDianti());
                    list3.add(merit.getHouse());
                    list3.add(merit.getFenjing());
                    list3.add(merit.getShequ());
                    break;
                case "深圳":
                    list4.add(merit.getCity());
                    list4.add(merit.getCaiguang());
                    list4.add(merit.getJiaotong());
                    list4.add(merit.getDianti());
                    list4.add(merit.getHouse());
                    list4.add(merit.getFenjing());
                    list4.add(merit.getShequ());
                    break;
            }
        }
        map.put("sh", list1);
        map.put("bj", list2);
        map.put("gz", list3);
        map.put("sz", list4);
        return map;
    }

    @RequestMapping("/housePC")
    @ResponseBody
    public Map getHousePeoAndCou(){
        Map<String,Object> map = new HashMap<>();
        //获取房子人关注数量
        List<HousePeople> list1 = houseService.getHousePeople();
        //获取关注房子数量
        List<HouseCount> list2 = houseService.getHouseCount();
        //存放房子
        List<String> citys = new ArrayList<>();
        //存放关注人数量
        List<Integer> ps = new ArrayList<>();
        //存放关注房子数量
        List<Integer> count = new ArrayList<>();
        for (HousePeople housePeople : list1) {
            ps.add(housePeople.getNumber());
        }
        for (HouseCount houseCount : list2) {
            citys.add(houseCount.getCity());
            count.add(houseCount.getNumber());
        }
        map.put("citys", citys);
        map.put("peocount", ps);
        map.put("housec", count);

        return map;
    }

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
