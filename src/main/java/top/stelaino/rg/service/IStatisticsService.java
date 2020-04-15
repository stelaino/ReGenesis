package top.stelaino.rg.service;

import top.stelaino.rg.entity.Statistics;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stelaino [bigmagician@outlook.com]
 * @since 2020-04-14
 */

public interface IStatisticsService extends IService<Statistics> {
    public Statistics getLastStatistic();
    public List<Statistics> getLastStatistics();
}
