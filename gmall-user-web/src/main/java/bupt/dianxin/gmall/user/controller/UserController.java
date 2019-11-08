package bupt.dianxin.gmall.user.controller;

import bupt.dianxin.gmall.api.bean.UmsMember;
import bupt.dianxin.gmall.api.bean.UmsMemberReceiveAddress;
import bupt.dianxin.gmall.api.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Reference
    UserService userService;

    //获取用户所有收货地址
    @RequestMapping("/getAllReceiveAddress")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getAllReceiveAddress(String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getAllReceiveAddress(memberId);
        return umsMemberReceiveAddresses;
    }

    //获取所有用户信息
    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }
}
