package bupt.dianxin.gmall.api.service;

import bupt.dianxin.gmall.api.bean.PmsBaseCatalog1;
import bupt.dianxin.gmall.api.bean.PmsBaseCatalog2;
import bupt.dianxin.gmall.api.bean.PmsBaseCatalog3;

import java.util.List;

public interface Catalog1Service {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
