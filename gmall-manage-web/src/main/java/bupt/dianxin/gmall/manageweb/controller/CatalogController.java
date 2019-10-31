package bupt.dianxin.gmall.manageweb.controller;

import bupt.dianxin.gmall.api.bean.PmsBaseCatalog1;
import bupt.dianxin.gmall.api.service.Catalog1Service;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@CrossOrigin
public class CatalogController {

    @Reference
    private Catalog1Service catalog1Service;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1= catalog1Service.getCatalog1();
        return catalog1;

    }

}
