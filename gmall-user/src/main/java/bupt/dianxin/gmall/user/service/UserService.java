package bupt.dianxin.gmall.user.service;

import bupt.dianxin.gmall.user.bean.UmsMember;
import bupt.dianxin.gmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getAllReceiveAddress(String memberId);
}
