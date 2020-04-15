package top.stelaino.rg.service;

import top.stelaino.rg.entity.Province;
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
public interface IProvinceService extends IService<Province> {
    public Province getLastProvince();

    public List<Province> getLastProvinces();
}
