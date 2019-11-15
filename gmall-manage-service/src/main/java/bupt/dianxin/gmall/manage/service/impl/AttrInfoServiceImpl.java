package bupt.dianxin.gmall.manage.service.impl;

import bupt.dianxin.gmall.api.bean.PmsBaseAttrInfo;
import bupt.dianxin.gmall.api.bean.PmsBaseAttrValue;
import bupt.dianxin.gmall.api.service.AttrService;
import bupt.dianxin.gmall.manage.mapper.AttrInfoMapper;
import bupt.dianxin.gmall.manage.mapper.AttrValueMapper;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AttrInfoServiceImpl implements AttrService {

    @Autowired
    AttrInfoMapper attrInfoMapper;

    @Autowired
    AttrValueMapper attrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> getBaseAttrInfo(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrInfoMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        String id = pmsBaseAttrInfo.getId();
        if(StringUtils.isBlank(id)){ //id为空  直接插入
            attrInfoMapper.insertSelective(pmsBaseAttrInfo);
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue attrValue : attrValueList) {
                attrValue.setAttrId(pmsBaseAttrInfo.getId());

                attrValueMapper.insert(attrValue);
            }
        }else{  //id不为空，修改操作，思路：先删除在插入
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());

            attrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);

            //获取属性值
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            //根据属性id删除所有属性
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            attrValueMapper.delete(pmsBaseAttrValue);

            //在插入属性值
            for(PmsBaseAttrValue value:attrValueList){
                attrValueMapper.insertSelective(value);
            }
        }

        return "Success";
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> pmsBaseAttrValues = attrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValues;
    }

}
