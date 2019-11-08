package bupt.dianxin.gmall.manageweb.controller;

import bupt.dianxin.gmall.api.bean.PmsBaseCatalog1;
import bupt.dianxin.gmall.api.bean.PmsBaseCatalog2;
import bupt.dianxin.gmall.api.bean.PmsBaseCatalog3;
import bupt.dianxin.gmall.api.service.Catalog1Service;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@CrossOrigin
public class CatalogController {

    @Reference
    Catalog1Service catalog1Service;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1= catalog1Service.getCatalog1();
        return catalog1;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        List<PmsBaseCatalog2> catalog2= catalog1Service.getCatalog2(catalog1Id);
        return catalog2;
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
        List<PmsBaseCatalog3> catalog3= catalog1Service.getCatalog3(catalog2Id);
        return catalog3;
    }

}
