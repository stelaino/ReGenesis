package top.stelaino.rg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.stelaino.rg.entity.Province;
import top.stelaino.rg.mapper.ProvinceMapper;
import top.stelaino.rg.service.IProvinceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stelaino [bigmagician@outlook.com]
 * @since 2020-04-15
 */
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements IProvinceService {

    @Override
    public Province getLastProvince() {
        QueryWrapper<Province> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT 1");
        return getOne(queryWrapper);

    }

    @Override
    public List<Province> getLastProvinces() {
        QueryWrapper<Province> queryWrapper = new QueryWrapper<>();
        //查询最后更新的数据,34是一次记录省份的个数
        queryWrapper.last("LIMIT "+(count()-34)+",34");
        return list(queryWrapper);
    }
}
