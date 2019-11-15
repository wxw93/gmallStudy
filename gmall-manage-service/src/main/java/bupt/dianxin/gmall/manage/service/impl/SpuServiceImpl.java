package bupt.dianxin.gmall.manage.service.impl;

import bupt.dianxin.gmall.api.bean.PmsProductInfo;
import bupt.dianxin.gmall.api.service.SpuService;
import bupt.dianxin.gmall.manage.mapper.SpuProductMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    SpuProductMapper spuProductMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = spuProductMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }
}
