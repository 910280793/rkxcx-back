package xcx.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xcx.com.domain.TestType;
import xcx.com.example.TestTypeExample;

public interface TestTypeMapper {
    long countByExample(TestTypeExample example);

    int deleteByExample(TestTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestType record);

    int insertSelective(TestType record);

    List<TestType> selectByExample(TestTypeExample example);

    List<TestType> selectBytype(TestType testType);

    TestType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestType record, @Param("example") TestTypeExample example);

    int updateByExample(@Param("record") TestType record, @Param("example") TestTypeExample example);

    int updateByPrimaryKeySelective(TestType record);

    int updateByPrimaryKey(TestType record);
}