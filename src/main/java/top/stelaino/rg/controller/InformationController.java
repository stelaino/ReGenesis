package top.stelaino.rg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.stelaino.rg.service.IInformationService;

import java.util.Map;

/**
 * @Auther: stelaino [bigmagician@outlook.com]
 * @Date: 2020/4/15 13:11
 * @Description:
 */
@RestController
@RequestMapping("info")
public class InformationController {
    @Autowired
    IInformationService informationServiceImpl;

    @RequestMapping("record")
    public Boolean recordInformations() {
        return informationServiceImpl.redordInformation();
    }

    @RequestMapping("get")
    public Map getInformations() {
       return informationServiceImpl.getInformation();
    }

}
