package bupt.dianxin.gmall.user.service.impl;

import bupt.dianxin.gmall.api.bean.UmsMember;
import bupt.dianxin.gmall.api.bean.UmsMemberReceiveAddress;
import bupt.dianxin.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import bupt.dianxin.gmall.user.mapper.UserMapper;
import bupt.dianxin.gmall.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        //原生的mybatis
        //List<UmsMember> umeMembers = userMapper.selectAllUser();
        //通用mapper
        List<UmsMember> umsMembers = userMapper.selectAllUser();
        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getAllReceiveAddress(String memberId) {
        //封装的参数对象
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> addresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return addresses;
    }
}


