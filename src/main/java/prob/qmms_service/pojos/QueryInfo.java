package prob.qmms_service.pojos;

import prob.qmms_service.models.enums.Frequency;
import prob.qmms_service.models.enums.Status;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class QueryInfo {

    private String queryId;
    private String query;
    private Frequency freq;
    private Status status;
    private String optyVer;
    private Date insDate;
    private Date updDate;
    private Collection<QueryAttributeInfo> attributes = new HashSet<>();

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Frequency getFreq() {
        return freq;
    }

    public void setFreq(Frequency freq) {
        this.freq = freq;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOptyVer() {
        return optyVer;
    }

    public void setOptyVer(String optyVer) {
        this.optyVer = optyVer;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public Collection<QueryAttributeInfo> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<QueryAttributeInfo> attributes) {
        this.attributes = attributes;
    }
}
