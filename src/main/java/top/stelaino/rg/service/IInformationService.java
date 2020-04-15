package top.stelaino.rg.service;

import java.util.Map;

/**
 * @Auther: stelaino [bigmagician@outlook.com]
 * @Date: 2020/4/15 12:30
 * @Description:
 */
public interface IInformationService {
    public Boolean redordInformation();

    public Boolean recordInformationPlaneB();

    public Map<String, Object> getInformation();
}
