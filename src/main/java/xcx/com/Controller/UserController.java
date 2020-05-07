package xcx.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xcx.com.Service.UserService;
import xcx.com.domain.TestType;
import xcx.com.domain.User;
import xcx.com.domain.Userinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
    private UserService userService;
  @RequestMapping("/addUser")
    public Userinfo addUser(User user){
      List<User> count=userService.selectOpenid(user.getOpenid());
      if(count.size()<=0) {
          int userid=userService.addUser(user);
          List<User> count3=userService.selectOpenid(user.getOpenid());
          Userinfo userInfo=new Userinfo();
          userInfo.setUserId(count3.get(0).getId());
          userInfo.setCtCount(0);userInfo.setScCount(0);userInfo.setDtCount(0);
          userService.saveOrUpdataInfo(userInfo);
          return userInfo;
      }else {
          Userinfo userInfo=userService.selectUserInfoByUserId(count.get(0).getId());
          return userInfo;
      }



  }
  @RequestMapping("/saveTest")
    public Userinfo saveTest(Userinfo userinfo){
      userService.saveOrUpdataInfo(userinfo);
      Userinfo userinfo1=userService.selectUserinfo(userinfo.getId());
      return  userinfo1;
  }


}
