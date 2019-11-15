package bupt.dianxin.gmall.api.service;

import bupt.dianxin.gmall.api.bean.PmsBaseAttrInfo;
import bupt.dianxin.gmall.api.bean.PmsBaseAttrValue;

import java.util.List;

public interface AttrService {

    List<PmsBaseAttrInfo> getBaseAttrInfo(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);
}
