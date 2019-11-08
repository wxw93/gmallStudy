package bupt.dianxin.gmall.manage.service.impl;

import bupt.dianxin.gmall.api.bean.PmsBaseCatalog1;
import bupt.dianxin.gmall.api.bean.PmsBaseCatalog2;
import bupt.dianxin.gmall.api.bean.PmsBaseCatalog3;
import bupt.dianxin.gmall.api.service.Catalog1Service;
import bupt.dianxin.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import bupt.dianxin.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import bupt.dianxin.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class Catalog1ServiceImpl implements Catalog1Service {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> pmsBaseCatalog1s = pmsBaseCatalog1Mapper.selectAll();
        return pmsBaseCatalog1s;
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 catalog2 = new PmsBaseCatalog2();
        catalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s = pmsBaseCatalog2Mapper.select(catalog2);
        return pmsBaseCatalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 catalog3 = new PmsBaseCatalog3();
        catalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog2s = pmsBaseCatalog3Mapper.select(catalog3);
        return pmsBaseCatalog2s;
    }


}
