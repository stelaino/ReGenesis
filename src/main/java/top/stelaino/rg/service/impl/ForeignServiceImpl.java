package top.stelaino.rg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.stelaino.rg.entity.Foreign;
import top.stelaino.rg.mapper.ForeignMapper;
import top.stelaino.rg.service.IForeignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 外国疫情统计 服务实现类
 * </p>
 *
 * @author stelaino [bigmagician@outlook.com]
 * @since 2020-04-15
 */
@Service
public class ForeignServiceImpl extends ServiceImpl<ForeignMapper, Foreign> implements IForeignService {

    @Override
    public Foreign getLastForeign() {
        QueryWrapper<Foreign> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT 1");
        return getOne(queryWrapper);
    }

    @Override
    public List<Foreign> getLastForeigns() {
        QueryWrapper<Foreign> queryWrapper = new QueryWrapper<>();
        //查询最近更新的212个国家
        queryWrapper.last("LIMIT "+(count()-212)+",212");
        return list(queryWrapper);
    }
}
