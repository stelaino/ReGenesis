package top.stelaino.rg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.stelaino.rg.entity.Timeline;
import top.stelaino.rg.mapper.TimelineMapper;
import top.stelaino.rg.service.ITimelineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author stelaino [bigmagician@outlook.com]
 * @since 2020-04-15
 */
@Service
public class TimelineServiceImpl extends ServiceImpl<TimelineMapper, Timeline> implements ITimelineService {

    @Override
    public List<Timeline> getLastTimelines() {
        QueryWrapper<Timeline> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("LIMIT "+(count()-6)+",6");
        return list(queryWrapper);
    }
}
