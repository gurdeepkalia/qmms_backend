package prob.qmms_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import prob.qmms_service.models.enums.Frequency;
import prob.qmms_service.models.enums.Status;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


@Entity
@Table(name = "CONFIG_QUERIES__H")
public class Query {
    @Id
    @Column(name="CQ_QUERY_ID")
    private String queryId;

    @Column(name="CQ_QUERY")
    private String query;

    @Enumerated(EnumType.STRING)
    @Column(name = "CQ_FREQUENCY")
    private Frequency freq;

    @Enumerated(EnumType.STRING)
    @Column(name = "CQ_STATUS")
    private Status status;

    @Column(name="CQ_OPTYMYZE_VERSION")
    private String optyVer;

    @Temporal(TemporalType.DATE)
    @Column(name="CQ_INSERT_DATE")
    private Date insDate;

    @Temporal(TemporalType.DATE)
    @Column(name="CQ_UPDATE_DATE")
    private Date updDate;

    //@JsonManagedReference
    @OneToMany(mappedBy = "query" , fetch = FetchType.LAZY , cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<QueryAttributes> attributes = new HashSet<>();

    public Query() {
    }

    public Query(String queryId, String query, Frequency freq, Status status, String optyVer, Date insDate, Date updDate) {
        this.queryId = queryId;
        this.query = query;
        this.freq = freq;
        this.status = status;
        this.optyVer = optyVer;
        this.insDate = insDate;
        this.updDate = updDate;
    }

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

    public Collection<QueryAttributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<QueryAttributes> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Query{" +
                "queryId='" + queryId + '\'' +
                ", query='" + query + '\'' +
                ", freq=" + freq +
                ", status=" + status +
                ", optyVer='" + optyVer + '\'' +
                ", insDate=" + insDate +
                ", updDate=" + updDate +
                '}';
    }
}
