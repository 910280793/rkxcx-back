package xcx.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xcx.com.example.AnswerExample;
import xcx.com.domain.Answer;

public interface AnswerMapper {
    long countByExample(AnswerExample example);

    int deleteByExample(AnswerExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Answer record);

    int insertSelective(Answer record);

    List<Answer> selectByExample(AnswerExample example);

    Answer selectByPrimaryKey(Integer aid);
    List<Answer> selectByPrimaryQid(int qid);

    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
}