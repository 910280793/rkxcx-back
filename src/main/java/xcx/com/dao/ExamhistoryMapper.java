package xcx.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xcx.com.domain.Examhistory;
import xcx.com.example.ExamhistoryExample;

public interface ExamhistoryMapper {
    long countByExample(ExamhistoryExample example);

    int deleteByExample(ExamhistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Examhistory record);

    int insertSelective(Examhistory record);

    List<Examhistory> selectByExample(ExamhistoryExample example);

    Examhistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Examhistory record, @Param("example") ExamhistoryExample example);

    int updateByExample(@Param("record") Examhistory record, @Param("example") ExamhistoryExample example);

    int updateByPrimaryKeySelective(Examhistory record);

    int updateByPrimaryKey(Examhistory record);

    Examhistory selectByPrimaryKey(String examId);

    int deleteByPrimaryKey(String examId);

    List<Examhistory> selectByExamHistory(Examhistory record);
}