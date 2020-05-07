package xcx.com.domain;

import java.io.Serializable;

/**
 * test_type
 * @author 
 */
public class TestType implements Serializable {
    private Integer id;

    private String name;

    private String dj;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj;
    }
}