package xcx.com.domain;

import java.io.Serializable;

/**
 * userinfo
 * @author 
 */
public class Userinfo implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer testId;

    private String testName;

    private Integer dtCount;

    private Integer scCount;

    private Integer ctCount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getDtCount() {
        return dtCount;
    }

    public void setDtCount(Integer dtCount) {
        this.dtCount = dtCount;
    }

    public Integer getScCount() {
        return scCount;
    }

    public void setScCount(Integer scCount) {
        this.scCount = scCount;
    }

    public Integer getCtCount() {
        return ctCount;
    }

    public void setCtCount(Integer ctCount) {
        this.ctCount = ctCount;
    }
}