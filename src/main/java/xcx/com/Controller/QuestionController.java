package xcx.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xcx.com.Service.AnswerService;
import xcx.com.Service.QuestionService;
import xcx.com.domain.Answer;
import xcx.com.domain.Question;
import xcx.com.domain.VoQuestion;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    @GetMapping("/saveQ")
    public void saveQuestion(){
        questionService.saveQuestion();
    }
    @GetMapping("/test")
    public void test(){
        System.out.println("test");;
    }
    @GetMapping("/testSave")
    public void testSave(){
        questionService.testSave();
}
   @RequestMapping("getQuestion")
    public VoQuestion getQuestion(int subject, int restore){
        Question question= questionService.getQuestion(subject,restore);
         List<Answer> list=answerService.getAnswerByid(question.getQid());
         VoQuestion voQuestion1=questionService.AsmQuestion(question);
         voQuestion1.setAnswerList(list);
        return voQuestion1;
   }
}
