package bupt.dianxin.gmall.api.service;


import bupt.dianxin.gmall.api.bean.UmsMember;
import bupt.dianxin.gmall.api.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getAllReceiveAddress(String memberId);
}
