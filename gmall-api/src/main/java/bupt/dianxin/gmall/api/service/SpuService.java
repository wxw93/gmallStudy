package bupt.dianxin.gmall.api.service;


import bupt.dianxin.gmall.api.bean.PmsProductInfo;

import java.util.List;

public interface SpuService {

    List<PmsProductInfo> spuList(String catalog3Id);
}
