package xcx.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xcx.com.dao.ExamhistoryMapper;
import xcx.com.domain.Examhistory;

import java.util.List;

@Service
public class ExamHistoryService {
    @Autowired
    private ExamhistoryMapper examhistoryMapper;

    public void saveExamHistory(Examhistory record){
        List<Examhistory> list=examhistoryMapper.selectByExamHistory(record);
        if(record.getAnswer().equals(record.getExamAnswer())){
            record.setStatus(1);
        }
        else record.setStatus(0);
        if(list.size()>0){
            record.setId(list.get(0).getId());
            examhistoryMapper.updateByPrimaryKeySelective(record);
        }else {
            examhistoryMapper.insert(record);
        }

    }
}
