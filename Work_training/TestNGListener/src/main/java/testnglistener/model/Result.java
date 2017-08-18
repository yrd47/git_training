package testnglistener.model;

import java.util.List;

/**
 * Created by yrd on 2017/5/24.
 *
 */
public class Result {

    private String id;
    private String domainId;
    private String divisionId;
    private String triggerId;
    private List<ResultDetails> resultDetailses;

    public Result() {
        super();
    }

    public Result (String domainId, String divisionId, String triggerId, List<ResultDetails> resultDetailses){
        super();
        this.domainId = domainId;
        this.divisionId = divisionId;
        this.triggerId = triggerId;
        this.resultDetailses = resultDetailses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(String triggerId) {
        this.triggerId = triggerId;
    }

    public List<ResultDetails> getResultDetailses() {
        return resultDetailses;
    }

    public void setResultDetailses(List<ResultDetails> resultDetailses) {
        this.resultDetailses = resultDetailses;
    }

}
