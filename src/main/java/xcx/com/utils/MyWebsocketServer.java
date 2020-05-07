package xcx.com.utils;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xcx.com.dao.UserMapper;
import xcx.com.dao.UserinfoMapper;
import xcx.com.domain.*;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Gjing
 **/
@ServerEndpoint("/webSocket/{param}")
@Component
@Slf4j
public class MyWebsocketServer {
    /**
     * 存放所有在线的客户端
     */
    public static ConcurrentHashMap<Integer,ConcurrentHashMap<Integer, Session>> roomList = new  ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Session>>();
    public static ConcurrentHashMap<Integer,Integer> roomSatus=new ConcurrentHashMap<>();
    public static  ConcurrentHashMap<Integer, List<VoQuestion>> roomQuestions=new  ConcurrentHashMap<Integer, List<VoQuestion>>();


    @OnOpen
    public void onOpen(Session session,@PathParam("param") String param) {
        String s = param;
        String[] str = s.split("\\.");
        Integer roomId = Integer.parseInt(str[1]);
        String userId = str[0];
        ConcurrentHashMap concurrentHashMap = roomList.get(roomId);
        System.out.println("userid"+userId);
        System.out.println("str1"+str[0]);
        System.out.println("str2"+str[1]);
        if(str.length<=2) {
            Integer status = roomSatus.get(roomId);
            if (concurrentHashMap.size() <= 2 && status == 0) {
                concurrentHashMap.put(Integer.parseInt(userId), session);
                System.out.println(roomId);
                System.out.println(userId);
                System.out.println("putsesion" + userId);
            } else {
                System.out.println("连接失败");
            }
        }else {
            concurrentHashMap.put(Integer.parseInt(userId), session);
            System.out.println("替换:"+roomId);
            System.out.println("替换"+userId);
            System.out.println("putsesion" + userId);
        }
    }
    /**
     * 客户端关闭
     * @param session session
     */
    @OnClose
    public void onClose(Session session) {

        //将掉线的用户移除在线的组里

    }

    /**
     * 发生错误
     * @param throwable e
     */
    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }


    /**
     * 收到客户端发来消息
     * @param message  消息对象
     */
    @OnMessage
    public void onMessage(String message) {
        System.out.println("mes:"+message);
        JSONObject object = JSONObject.parseObject(message);
        Integer userId=object.getInteger("userId");
        Integer action=object.getInteger("action");
        Integer roomId=object.getInteger("roomId");
        if(action==1010) {

            this.sendds(message,roomId,userId);
        }
        if(action==1011) {

            this.sendds(message,roomId,userId);
        }
        if(action==1021) {

            this.sendds(message,roomId,userId);
        }

    }


    /**
     * 群发消息
     * @param message 消息内容
     */
    private void sendds(String message,Integer roomId,Integer userId) {
        ConcurrentHashMap concurrentHashMap2= MyWebsocketServer.roomList;
        System.out.println("sendssRoom"+roomId);
        ConcurrentHashMap<Integer,Session> concurrentHashMap= MyWebsocketServer.roomList.get(roomId);
        Set<Integer> set=concurrentHashMap.keySet();

        PkUser pkUser=new PkUser();
        for (Integer o : set) {
            if(o!=userId) {
                Session session = concurrentHashMap.get(o);
                sendMsg(message,session);
            }

        }

    }
    private void sendAll(String message,Integer roomId) {
        ConcurrentHashMap<Integer,Session> concurrentHashMap= MyWebsocketServer.roomList.get(roomId);
        Set<Integer> set=concurrentHashMap.keySet();

        PkUser pkUser=new PkUser();
        for (Integer o : set) {
            Session session=concurrentHashMap.get(o);
           sendMsg(message,session);

        }

    }
    private void sendMsg(String message,Session session) {
        if (session == null) {
            return;
        }

        final RemoteEndpoint.Basic basic = session.getBasicRemote();
        if (basic == null) {
            return;
        }

        try {
            basic.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
