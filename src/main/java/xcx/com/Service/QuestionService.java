package xcx.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xcx.com.dao.AnswerMapper;
import xcx.com.dao.QuestionMapper;
import xcx.com.domain.Answer;
import xcx.com.domain.Question;
import xcx.com.domain.VoQuestion;
import xcx.com.utils.ioTest;

@Service
public class QuestionService {
    @Autowired
    private  QuestionMapper questionMapper;
    @Autowired
    private  AnswerMapper answerMapper;
    @Autowired
    private ioTest ioTest;
    public void saveQuestion() {
        ioTest.saveQuestion();
    }

    public void  testSave(){
        Answer answer=new Answer();
        answer.setAnswerContent("aa");answer.setGrade(1);answer.setAnswerNumber("A");
        answerMapper.insertSelective(answer);
    }
    public Question getQuestion(int testId,int xh){
        return questionMapper.MyselectByTestIdXh(xh,testId);
    }
    public VoQuestion AsmQuestion(Question question){
        VoQuestion voQuestion=new VoQuestion();
        voQuestion.setAnalysisimage(question.getAnalysisimage());
        voQuestion.setAnalysis(question.getAnalysis());
        voQuestion.setAnswer(question.getAnswer());
        voQuestion.setCategory(question.getCategory());
        voQuestion.setContent(question.getContent());
        voQuestion.setDescribe(question.getDescribe());
        voQuestion.setImage(question.getImage());
        voQuestion.setMonth(question.getMonth());
        voQuestion.setQid(question.getQid());
        voQuestion.setTestId(question.getTestId());
        voQuestion.setQtype(question.getQtype());
        voQuestion.setType(question.getType());
        voQuestion.setYear(question.getYear());
        voQuestion.setXh(question.getXh());
        return voQuestion;

    }

}
