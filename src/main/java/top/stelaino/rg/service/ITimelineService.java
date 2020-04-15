package top.stelaino.rg.service;

import top.stelaino.rg.entity.Timeline;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stelaino [bigmagician@outlook.com]
 * @since 2020-04-15
 */
public interface ITimelineService extends IService<Timeline> {
    public List<Timeline> getLastTimelines();
}
