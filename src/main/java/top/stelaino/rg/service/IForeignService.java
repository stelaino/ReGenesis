package top.stelaino.rg.service;

import top.stelaino.rg.entity.Foreign;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 外国疫情统计 服务类
 * </p>
 *
 * @author stelaino [bigmagician@outlook.com]
 * @since 2020-04-15
 */
public interface IForeignService extends IService<Foreign> {
    public Foreign getLastForeign();
    public List<Foreign> getLastForeigns();
}
