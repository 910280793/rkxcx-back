package xcx.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xcx.com.dao.TestMapper;
import xcx.com.dao.TestTypeMapper;
import xcx.com.domain.TestType;
import xcx.com.example.TestExample;
import xcx.com.domain.Test;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private TestTypeMapper testTypeMapper;

    public List<Test> list(){
        return  testMapper.selectByExample(new TestExample());
    }
    public List<TestType> typeList(TestType testType){
        return testTypeMapper.selectBytype(testType);
    }
    public Test getTest(int id){
        return testMapper.selectByPrimaryKey(id);
    }


}
