package top.stelaino.rg.utils;

/**
 * @Auther: stelaino [bigmagician@outlook.com]
 * @Date: 2020/4/14 17:48
 * @Description: 网址、正则表达式
 */
public class NCovCrawler {
    public static final String URL ="https://3g.dxy.cn/newh5/view/pneumonia";
    /**
     * 时间线新闻
     */
    public static final String TIME_LINE_REGEX_TEMPLATE = "\\[(.*?)\\]";
    public static final String TIME_LINE_ATTRIBUTE="getTimelineService1";
    /**
     * 各省信息
     */
    public static final String AREA_INFORMATION_REGEX_TEMPLATE = "\\[(.*)\\]";
    public static final String AREA_INFORMATION_ATTRIBUTE="getAreaStat";
    /**
     * 总数据
     */
    public static final String STATIC_INFORMATION_REGEX_TEMPLATE_1="\\{(\"id\".*)\\}";
    public static final String STATIC_INFORMATION_REGEX_TEMPLATE_3="\\{(\"id\".*?)\\}\\}";
    public static final String STATIC_INFORMATION_REGEX_TEMPLATE_2="\\{\"id\"(.*?\\}){38}";
    public static final String STATIC_INFORMATION_ATTRIBUTE="getStatisticsService";
    /**
     * 各国数据
     */
    public static final String COUNTRY_REGEX_TEMPLATE = "\\[(.*?)\\]";
    public static final String COUNTRY_ATTRIBUTE="getListByCountryTypeService2true";
}
