package bupt.dianxin.gmall.manage.service.impl;

import bupt.dianxin.gmall.api.bean.PmsBaseCatalog1;
import bupt.dianxin.gmall.api.service.Catalog1Service;
import bupt.dianxin.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Catalog1ServiceImpl implements Catalog1Service {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> pmsBaseCatalog1s = pmsBaseCatalog1Mapper.selectAll();
        return pmsBaseCatalog1s;
    }
}
