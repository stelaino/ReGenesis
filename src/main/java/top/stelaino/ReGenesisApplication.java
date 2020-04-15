package top.stelaino;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Auther: stelaino [bigmagician@outlook.com]
 * @Date: 2020/4/14 16:58
 * @Description:
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.stelaino.rg.mapper"})
@EnableScheduling
public class ReGenesisApplication {
    private static Logger logger = LoggerFactory.getLogger(ReGenesisApplication.class);
    public static void main(String[] args) {
        logger.info("爬虫服务已启动");
        Long start = System.currentTimeMillis();
        SpringApplication.run(ReGenesisApplication.class,args);
        logger.info("执行SpringApplication耗时:"+(System.currentTimeMillis()-start)+"毫秒");
    }
}
