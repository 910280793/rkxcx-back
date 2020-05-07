package xcx.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xcx.com.Service.TestService;
import xcx.com.domain.Test;
import xcx.com.domain.TestType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/list")
    public List<Test> list(){
        return testService.list();
    }
    @RequestMapping("/typeList")
    public Map<String,List<TestType>> typeList(){
        HashMap map=new HashMap<String,List<TestType>>();

        TestType testType=new TestType();
        List list1=new ArrayList<TestType>();
        testType.setDj("初级");
        list1= testService.typeList(testType);
        map.put("L3",list1);
        List list2=new ArrayList<TestType>();
        testType.setDj("中级");
        list2= testService.typeList(testType);
        map.put("L2",list2);
        List list3=new ArrayList<TestType>();
        testType.setDj("高级");
        list3= testService.typeList(testType);
        map.put("L1",list3);
        return map;
    }
    @RequestMapping("/getTest")
    public Test getTest(int id){
        return testService.getTest(id);
    }

}
