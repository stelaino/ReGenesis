package top.stelaino.rg.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.stelaino.rg.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: stelaino [bigmagician@outlook.com]
 * @Date: 2020/4/15 9:14
 * @Description:
 */
public class InformationUtils {
    private static final Logger logger = LoggerFactory.getLogger(InformationUtils.class);

    /**
     * 记录数据前更新数据
     */
    public static void updateData() {
        //配置数据网址
        ParseTools.setDocument("https://3g.dxy.cn/newh5/view/pneumonia");
    }

    /**
     * 获取病例数据
     *
     * @return
     */
    public static Statistics getStatistics() {
        String statisticsInfo = null;
        try {
            statisticsInfo = ParseTools.getInformation(NCovCrawler.STATIC_INFORMATION_REGEX_TEMPLATE_1, "id", NCovCrawler.STATIC_INFORMATION_ATTRIBUTE);
            statisticsInfo = statisticsInfo.replace("}catch(e){}", "");
        } catch (Exception e) {
            try {
                statisticsInfo = ParseTools.getInformation(NCovCrawler.STATIC_INFORMATION_REGEX_TEMPLATE_2, "id", NCovCrawler.STATIC_INFORMATION_ATTRIBUTE);
            } catch (Exception ex) {
                statisticsInfo = ParseTools.getInformation(NCovCrawler.STATIC_INFORMATION_REGEX_TEMPLATE_3, "id", NCovCrawler.STATIC_INFORMATION_ATTRIBUTE);
            }
        }
        //转换为对象
        Statistics statistics = JSON.parseObject(statisticsInfo, Statistics.class);
        //属性校正
        statistics.correctionInformation();
        return statistics;
    }

    /**
     * 获取媒体报导
     *
     * @return
     */
    public static List<Timeline> getTimelines() {
        String information = ParseTools.getInformation(NCovCrawler.TIME_LINE_REGEX_TEMPLATE, "id", NCovCrawler.TIME_LINE_ATTRIBUTE);
        List<Timeline> list = JSONArray.parseArray(information, Timeline.class);
        //校正发布时间
        list.forEach((timeline -> timeline.correctionInformation() ));
        return list;
    }

    public static List<Province> getProvinces() {
        String information = ParseTools.getInformation(NCovCrawler.AREA_INFORMATION_REGEX_TEMPLATE, "id", NCovCrawler.AREA_INFORMATION_ATTRIBUTE);
        List<Province> provinces = JSONArray.parseArray(information, Province.class);
        return provinces;
    }

    public static List<City> getCitys() {
        List<Province> provinces = getProvinces();
        List<City> cities = new ArrayList<>();
        provinces.forEach(province -> {
            province.correctionInformation();
            cities.addAll(province.getCities());
        });
        return cities;
    }
    public static List<City> getCitys(List<Province> provinces) {
        List<City> cities = new ArrayList<>();
        provinces.forEach(province -> {
            province.correctionInformation();
            cities.addAll(province.getCities());
        });
        return cities;
    }
    public static List<Foreign> getForeigns() {
        String information = ParseTools.getInformation(NCovCrawler.COUNTRY_REGEX_TEMPLATE, "id", NCovCrawler.COUNTRY_ATTRIBUTE);
        List<Foreign> foreignList = JSONArray.parseArray(information, Foreign.class);
        foreignList.forEach(foreign -> {
            foreign.correctionInformation();
        });
        return foreignList;
    }
}
