package xcx.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xcx.com.Service.ExamHistoryService;
import xcx.com.domain.Examhistory;

@Controller
@RestController
@RequestMapping("/exam")
public class ExamHistory {
    @Autowired
    private ExamHistoryService examHistoryService;

    @RequestMapping("/saveExamHistory")
    public void saveExamHistory(Examhistory examHistory){
        examHistoryService.saveExamHistory(examHistory);
    }
}
