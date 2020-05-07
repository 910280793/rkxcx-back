package xcx.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xcx.com.dao.AnswerMapper;
import xcx.com.domain.Answer;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    public AnswerMapper answerMapper;

    public List<Answer> getAnswerByid(int qid){
        List<Answer> list=answerMapper.selectByPrimaryQid(qid);
        return list;

    }

}
