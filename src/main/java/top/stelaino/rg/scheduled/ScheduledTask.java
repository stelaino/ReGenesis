package top.stelaino.rg.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.stelaino.rg.service.IInformationService;

/**
 * @Auther: stelaino [bigmagician@outlook.com]
 * @Date: 2020/4/15 19:37
 * @Description:
 */
@Component
public class ScheduledTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    @Autowired
    IInformationService informationServiceImpl;
    /**
     * 定时爬取任务
     */
    @Scheduled(fixedRate = 1000*60*10)
    public void CrawlerTask() {
//        logger.info("爬取任务执行");
        Boolean result = informationServiceImpl.redordInformation();
    }
}
