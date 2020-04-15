package top.stelaino.rg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.stelaino.rg.entity.City;
import top.stelaino.rg.mapper.CityMapper;
import top.stelaino.rg.service.ICityService;
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
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {

    @Override
    public City getLastCity() {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT 1");
        return getOne(queryWrapper);
    }

    @Override
    public List<City> getLastCities() {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        //查询最近更新的城市
        queryWrapper.last("LIMIT "+(count()-442)+",442");
        return list(queryWrapper);
    }
}
