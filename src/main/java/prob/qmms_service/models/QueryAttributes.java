package prob.qmms_service.models;



import com.fasterxml.jackson.annotation.JsonBackReference;

import prob.qmms_service.models.enums.DataTypes;


import javax.persistence.*;

@Entity
@Table(name = "CONFIG_QUERY_ATTRIBUTES_H")
public class QueryAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CQA_ID")
    private long id;

    //@JsonBackReference
    @ManyToOne
    @JoinColumn(name="CQA_QUERY_ID")
    private Query query;

    @Column(name = "CQA_QUERY_ATTRIBUTE")
    private String queryAttribute;

    @Enumerated(EnumType.STRING)
    @Column(name="CQA_QUERY_ATT_DATATYPE")
    private DataTypes attributeDatatype;

    @Column(name="CQA_ATT_ORDER")
    private int columnNumber;

    public QueryAttributes() {
    }

    public QueryAttributes(String queryAttribute, DataTypes attributeDatatype, int columnNumber) {
        this.queryAttribute = queryAttribute;
        this.attributeDatatype = attributeDatatype;
        this.columnNumber = columnNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public String getQueryAttribute() {
        return queryAttribute;
    }

    public void setQueryAttribute(String queryAttribute) {
        this.queryAttribute = queryAttribute;
    }

    public DataTypes getAttributeDatatype() {
        return attributeDatatype;
    }

    public void setAttributeDatatype(DataTypes attributeDatatype) {
        this.attributeDatatype = attributeDatatype;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
}
