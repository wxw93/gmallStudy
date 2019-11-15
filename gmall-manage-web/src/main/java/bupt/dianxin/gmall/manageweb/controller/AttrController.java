package bupt.dianxin.gmall.manageweb.controller;

import bupt.dianxin.gmall.api.bean.PmsBaseAttrInfo;
import bupt.dianxin.gmall.api.bean.PmsBaseAttrValue;
import bupt.dianxin.gmall.api.service.AttrService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {
    @Reference
    AttrService attrService;

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> getBaseAttrInfo(String catalog3Id){
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> baseAttrInfos = attrService.getBaseAttrInfo(catalog3Id);
        return baseAttrInfos;
    }

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        String success = attrService.saveAttrInfo(pmsBaseAttrInfo);
        return "Success";
    }


    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        PmsBaseAttrValue pmsBaseAttrValues = new PmsBaseAttrValue();
        pmsBaseAttrValues.setAttrId(attrId);
        List<PmsBaseAttrValue> baseAttrValues = attrService.getAttrValueList(attrId);
        return baseAttrValues;
    }


}
