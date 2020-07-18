package prob.qmms_service.models.enums;

public enum DataTypes {
    VARCHAR2("VARCHAR2"),NUMBER("NUMBER"),DATE("DATE"),CHAR("CHAR"),LONG("LONG");

    String dataTypeName;

    DataTypes(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    public static DataTypes getDataType(String dt)
    {
        for(DataTypes dType : DataTypes.values())
        {
            if(dt.equals(dType.dataTypeName))
            {
                return dType;
            }
        }
        return null;   //handle using User defined Exception
    }
}
