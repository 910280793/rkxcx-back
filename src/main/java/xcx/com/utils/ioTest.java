package xcx.com.utils;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xcx.com.dao.AnswerMapper;
import xcx.com.dao.QuestionMapper;
import xcx.com.domain.Answer;
import xcx.com.domain.Question;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ioTest {
    @Autowired
    private  QuestionMapper questionMapper;
    @Autowired
    private  AnswerMapper answerMapper;
    public static String type="网络工程师";
    public static String year="2018";
    public static String month="上";
    public static String imagedirname=type+year+month;
    public static String docPath = "E:/2018s.docx";

    //public static String textPath = "src/main/resources/test.txt";

    public static String imagePath = "src/main/resources/static/image/";

    //存储word到数据库
    public   void saveQuestion(){
        String string=readDocxText();
        String[] arr=string.split("\\$");
        ArrayList<ArrayList<String>> arrayLists=jxTest(arr);

        for(int i=0;i<arrayLists.size();i++){
             ArrayList<String> tmparr=arrayLists.get(i);
            //存储单选题
            if(isDxt(tmparr.get(0))){
                String qtype="单选题";
               HashMap<String,String> xuanx=ans(tmparr.get(0));
               String content=repalceAns(tmparr.get(0));
               String ans=tmparr.get(1).replace(" ","").replace(",","");
                Question question=new Question();
                question.setXh(i+1);
                question.setContent(content);question.setType(type);question.setQtype(qtype);question.setAnswer(ans);
                if(tmparr.size()>2)
                question.setAnalysis(tmparr.get(2));
                question.setYear(year);question.setMonth(month);
                question.setTestId(2);
                questionMapper.insertSelective(question);
                for(String s:xuanx.keySet()){
                    Answer answer=new Answer();
                    answer.setQid(question.getQid());
                    answer.setAnswerNumber(s);
                    answer.setAnswerContent(xuanx.get(s));
                    answer.setGrade(1);
                    answerMapper.insertSelective(answer);
                }
            }else{
                String qtype="多选题";

                HashMap<String,String> xuanx=ans(tmparr.get(0));
                String ans=tmparr.get(1).replace(" ","").replace(",","");
                Question question=new Question();
                question.setContent(tmparr.get(0));question.setType(type);question.setQtype(qtype);question.setAnswer(ans);
                if(tmparr.size()>2)
                question.setAnalysis(tmparr.get(2));
                question.setTestId(2);
                question.setXh(i+1);
                question.setYear(year);question.setMonth(month);
               questionMapper.insertSelective(question);
                for(String s:xuanx.keySet()){
                    Answer answer=new Answer();
                    answer.setQid(question.getQid());
                    answer.setAnswerNumber(s);
                    answer.setAnswerContent(xuanx.get(s));
                    answer.setGrade(1);

                    answerMapper.insertSelective(answer);
                }
            }
        }
    }
    //把题目,答案,解析分开
    public static ArrayList<ArrayList<String>> jxTest(String[] question){

        ArrayList<ArrayList<String>> arr=new ArrayList<ArrayList<String>>();
        for(int i=1;i<question.length;i++){
            String[] tempArr=question[i].split("【答案】");
            ArrayList<String> arrayList=new ArrayList<>();
            arrayList.add(tempArr[0]);
            String[] temparr2=tempArr[1].split("【解析】");
            arrayList.add(temparr2[0]);
            //没有解析
            if(temparr2.length>=2)
            arrayList.add(temparr2[1]);
            arr.add(arrayList);
        }
        return  arr;
    }

    public static String readDocxText() {

        try {
            // 用XWPFWordExtractor来获取文字
            FileInputStream fileInputStream=new FileInputStream(new File(docPath));
            XWPFDocument document = new XWPFDocument(fileInputStream);
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(document);
            String text = xwpfWordExtractor.getText();
            //将获取到的文字存放到对应文件名中的txt文件中
            //PrintStream ps = new PrintStream(textPath);
            //ps.println(text);



            fileInputStream.close();
            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void readImage(){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(docPath));
            XWPFDocument document = new XWPFDocument(fileInputStream);
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(document);
            // 用XWPFDocument的getAllPictures来获取所有的图片
            File dir = new File(imagePath + imagedirname);
            if (!dir.exists()) {
                dir.mkdir();
            }
            List<XWPFPictureData> picList = document.getAllPictures();
            for (XWPFPictureData pic : picList) {
                byte[] bytev = pic.getData();
                // 大于1000bites的图片我们才弄下来，消除word中莫名的小图片的影响
                if (bytev.length > 300) {
                    FileOutputStream fos = new FileOutputStream(imagePath + imagedirname + "/" + pic.getFileName());
                    fos.write(bytev);
                }
            }
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //去掉题目中的选项
    public static String repalceAns(String body){
        String s2="[ABCD]\\..*[\\t\\n]";
        Pattern pattern=Pattern.compile(s2);
        String body1=body;
        Matcher matcher = pattern.matcher(body);
        while(matcher.find()){
            String tmp=matcher.group(0);
            //去掉题目中的选项

            body1=body1.replace(tmp,"");
        }
        
        return body1;
    }
    //提取题目中选项内容
    public static HashMap<String,String> ans(String s){
        HashMap hashMap =new HashMap<String,String>();
        String s2="[ABCD]\\..*[\\t\\n]";
        Pattern pattern=Pattern.compile(s2);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            String tmp=matcher.group(0);
            String[] arr=tmp.split("\\.");
            hashMap.put(arr[0],arr[1]);
        }
        return hashMap;
    }
    //判断是否是多选题
    public static boolean isDxt(String qs){
        if(qs.contains("|")){
            return false;
        }else return true;
    }

}
