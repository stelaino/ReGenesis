package top.stelaino.rg.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.stelaino.rg.utils.InformationUtils;
import top.stelaino.rg.entity.*;
import top.stelaino.rg.mapper.CityMapper;
import top.stelaino.rg.mapper.ProvinceMapper;
import top.stelaino.rg.mapper.StatisticsMapper;
import top.stelaino.rg.mapper.TimelineMapper;
import top.stelaino.rg.service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: stelaino [bigmagician@outlook.com]
 * @Date: 2020/4/15 12:35
 * @Description:
 */
@Service
public class InformationServiceImpl implements IInformationService {
    private static final Logger logger = LoggerFactory.getLogger(InformationServiceImpl.class);
    @Autowired
    StatisticsMapper statisticsMapper;
    @Autowired
    TimelineMapper timelineMapper;
    @Autowired
    ProvinceMapper provinceMapper;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    IStatisticsService statisticsServiceImpl;
    @Autowired
    ITimelineService timelineServiceImpl;
    @Autowired
    IProvinceService provinceServiceImpl;
    @Autowired
    ICityService cityServiceImpl;
    @Autowired
    IForeignService foreignServiceImpl;

    @Override
    public Boolean redordInformation() {
        InformationUtils.updateData();
        Statistics statistics = InformationUtils.getStatistics();
        //查询的数据为最新发布的信息则直接返回
        if ((statisticsServiceImpl.getLastStatistic().getRecordTime()).equals(statistics.getRecordTime())) {
            logger.info("发布信息无更新无需记录");
            return false;
        }
        //范围疫情信息记录
        List<Statistics> statisticsList = new ArrayList<>();
        statisticsList.add(statistics);
        statisticsList.add(statistics.getForeignStatistics());
        statisticsList.add(statistics.getGlobalStatistics());
        statisticsServiceImpl.saveBatch(statisticsList);
        //时间线疫情信息记录
        List<Timeline> timelineList = InformationUtils.getTimelines();
        timelineServiceImpl.saveOrUpdateBatch(timelineList);
        //全国省份疫情信息记录
        List<Province> provinceList = InformationUtils.getProvinces();
        provinceServiceImpl.saveBatch(provinceList);
        //地级市疫情信息记录
        List<City> cityList = InformationUtils.getCitys(provinceList);
        cityServiceImpl.saveBatch(cityList);
        //国家疫情信息记录
        List<Foreign> foreignList = InformationUtils.getForeigns();
        foreignServiceImpl.saveBatch(foreignList);
        logger.info("疫情信息记录成功");
        return true;
    }

    /**
     * 废弃代码
     * @return
     */
    @Override
    public Boolean recordInformationPlaneB() {
        InformationUtils.updateData();
        //查询的数据为最新发布的信息则直接返回
        Statistics statistics = InformationUtils.getStatistics();
        if ((statisticsServiceImpl.getLastStatistic().getRecordTime()).equals(statistics.getRecordTime())) {
            logger.info("发布信息无更新无需记录");
            return false;
        }
        statisticsMapper.insert(statistics);
        statisticsMapper.insert(statistics.getForeignStatistics());
        statisticsMapper.insert(statistics.getGlobalStatistics());
        logger.info("全球疫情信息已记录");
        //新闻发布
        List<Timeline> timelines = InformationUtils.getTimelines();
        timelines.forEach((timeline -> timelineMapper.insert(timeline)));
        logger.info("时间线播报已记录");
        //省市
        List<Province> provinceList = InformationUtils.getProvinces();
        provinceList.forEach(province -> provinceMapper.insert(province));
        logger.info("省份疫情信息记录成功");
        List<City> cityList = InformationUtils.getCitys(provinceList);
        cityList.forEach(city -> cityMapper.insert(city));
        logger.info("地级市疫情信息记录成功");
        return true;
    }

    public Map<String, Object> getInformation() {
        Map<String, Object> map = new HashMap<>();
        map.put("statistics", statisticsServiceImpl.getLastStatistics());
        map.put("provinces",provinceServiceImpl.getLastProvinces());
        map.put("timelines",timelineServiceImpl.getLastTimelines());
        map.put("citis", cityServiceImpl.getLastCities());
        map.put("country", foreignServiceImpl.getLastForeigns());
        return map;
    }
}
