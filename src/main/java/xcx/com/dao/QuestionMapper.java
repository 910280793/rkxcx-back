package xcx.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xcx.com.domain.Question;
import xcx.com.example.QuestionExample;

public interface QuestionMapper {
    long countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer qid);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);
    List<Question> pkQue(String type,Integer start);
    Question selectByPrimaryKey(Integer qid);
    Question MyselectByTestIdXh(Integer xh,Integer testId);
    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}