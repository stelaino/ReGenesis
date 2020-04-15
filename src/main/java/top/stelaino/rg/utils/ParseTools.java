package top.stelaino.rg.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: stelaino [bigmagician@outlook.com]
 * @Date: 2020/4/14 17:17
 * @Description:
 */
public class ParseTools {
    private static final Logger logger = LoggerFactory.getLogger(ParseTools.class);
    public static Document document;

    /**
     * 根据正则表达式截取需要的数据(本段代码参考项目:Ticsmyc/2019nCoV-Crawler)
     * @param regex
     * @param attributeKey
     * @param attributeValue
     * @return
     */
    public static String getInformation(String regex , String attributeKey, String attributeValue){
        String result=null;
        //表达式对象
        Pattern p = Pattern.compile(regex);
        //创建Matcher对象
        Elements timelineService = document.getElementsByAttributeValue(attributeKey,attributeValue);
        Matcher m = p.matcher(timelineService.toString());
        if(m.find()) {
            //该方法扫描输入的序列，查找与该模式匹配的一个子序列
            result=m.group();
        }
        return result;
    }

    public static void setDocument(String url) {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.error("获取页面失败");
        }
    }
}
