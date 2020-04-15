package top.stelaino.rg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.stelaino.rg.entity.Statistics;
import top.stelaino.rg.mapper.StatisticsMapper;
import top.stelaino.rg.service.IStatisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author stelaino [bigmagician@outlook.com]
 * @since 2020-04-14
 */
@Service
public class StatisticsServiceImpl extends ServiceImpl<StatisticsMapper, Statistics> implements IStatisticsService {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsServiceImpl.class);

    @Override
    public Statistics getLastStatistic() {
        QueryWrapper<Statistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT 1");
        return getOne(queryWrapper);
    }

    @Override
    public List<Statistics> getLastStatistics() {
        QueryWrapper<Statistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("LIMIT "+(count()-3)+",3");
        return list(queryWrapper);
    }
}
