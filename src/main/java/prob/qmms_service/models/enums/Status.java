package prob.qmms_service.models.enums;

public enum Status {
    ENABLE("ENABLE"),DISABLE("DISABLE");
    String value;
    Status(String value)
    {
        this.value = value;
    }

    public static Status getStatus(String status)
    {
        for(Status s : Status.values())
        {
            if(status.equals(s.value))
            {
                return s;
            }
        }
        return null;     //handle the exception
    }
}
