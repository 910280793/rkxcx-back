package xcx.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xcx.com.dao.TestTypeMapper;
import xcx.com.dao.UserMapper;
import xcx.com.dao.UserinfoMapper;
import xcx.com.domain.TestType;
import xcx.com.domain.User;
import xcx.com.domain.Userinfo;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private TestTypeMapper testTypeMapper;

    public int addUser(User user){
        int id=userMapper.insert(user);
        return id;
    }
    public List<User> selectOpenid(String openid){
        List a=userMapper.selectOpenid(openid);
        return a;
    }
    public void saveOrUpdataInfo(Userinfo userinfo){
    if(userinfo.getId()==null){
        userinfoMapper.insertSelective(userinfo);
    }
    else {
        TestType testType=testTypeMapper.selectByPrimaryKey(userinfo.getTestId());
        userinfo.setTestName(testType.getName());
        userinfoMapper.updateByPrimaryKeySelective(userinfo);
    }
    }
    public Userinfo selectUserInfoByUserId(int userId){
        Userinfo userinfo=userinfoMapper.selectByUserId(userId);
        return  userinfo;
}
    public Userinfo selectUserinfo(int id){
        Userinfo userinfo=userinfoMapper.selectByPrimaryKey(id);
        return userinfo;
    }

}
