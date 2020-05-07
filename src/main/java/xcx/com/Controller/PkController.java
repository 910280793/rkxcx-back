package xcx.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xcx.com.Service.AnswerService;
import xcx.com.Service.QuestionService;
import xcx.com.dao.QuestionMapper;
import xcx.com.dao.UserMapper;
import xcx.com.domain.*;
import xcx.com.utils.MyWebsocketServer;


import javax.websocket.Session;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/pk")
public class PkController {
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public QuestionMapper questionMapper;
    @Autowired
    public QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @RequestMapping("/room-init")
    public Map createRoom(){
        int roomid=(int)(Math.random()*10000-1);
        MyWebsocketServer.roomList.put(roomid,new ConcurrentHashMap<Integer, Session>());
        MyWebsocketServer.roomSatus.put(roomid,0);
        Map map=new HashMap();
        map.put("roomid",roomid);
        return map;
    }
    @RequestMapping("/room-info")
    public Map getRoomInfo(int roomId,int userId){
        System.out.println("roominfo roomid:"+roomId);
        System.out.println("roominfo: userid"+userId);
        int dsUserId=0;
        ConcurrentHashMap<Integer,Session> concurrentHashMap= MyWebsocketServer.roomList.get(roomId);
        Set<Integer> set=concurrentHashMap.keySet();

        PkUser pkUser=new PkUser();
        for (Integer o : set) {

             if (o!=userId)
                 dsUserId=o;
        }
        User user=userMapper.selectByPrimaryKey(dsUserId);
        Map<String,String> map=new HashMap<>();
        map.put("dsUserId",String.valueOf(dsUserId));
        map.put("dsName",user.getNickname());
        map.put("dsAvatarUrl",user.getAvaterurl());
        return map;
    }
    @RequestMapping("/room-check")
    public Map roomCheck(int roomId){
        Map<String,Integer> map=new HashMap();
        Integer s=MyWebsocketServer.roomSatus.get(roomId);
        map.put("status",s);
        return map;
    }
    @RequestMapping("/roomQuestion")
    public Map roomQue(Integer roomId,Integer userId){
        Map map=new HashMap();
        if(MyWebsocketServer.roomQuestions.containsKey("roomId") ){
            List<VoQuestion> list=MyWebsocketServer.roomQuestions.get("roomId");
            map.put("list",list);
        }else {
            List<Question> list=questionMapper.pkQue("网络工程师",0);
            List<VoQuestion> voQuestionList=new ArrayList<>();
            for (Question question : list) {
                List<Answer> alist=answerService.getAnswerByid(question.getQid());
                VoQuestion voQuestion1=questionService.AsmQuestion(question);
                voQuestion1.setAnswerList(alist);
                voQuestionList.add(voQuestion1);
            }
            MyWebsocketServer.roomQuestions.put(roomId,voQuestionList);
            map.put("list",voQuestionList);
        }
        return  map;
    }
}
