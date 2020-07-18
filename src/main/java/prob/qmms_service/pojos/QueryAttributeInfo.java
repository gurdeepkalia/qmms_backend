package prob.qmms_service.pojos;

import prob.qmms_service.models.enums.DataTypes;

public class QueryAttributeInfo {

    private String queryAttribute;
    private DataTypes attributeDatatype;
    private int columnNumber;

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
