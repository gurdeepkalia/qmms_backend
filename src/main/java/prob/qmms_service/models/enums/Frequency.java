package prob.qmms_service.models.enums;

public enum Frequency {
    DAILY("DAILY"),WEEKLY("WEEKLY"),YEARLY("YEARLY"),MONTHLY("MONTHLY");
    String value;

    Frequency(String value) {
        this.value = value;
    }



    public static Frequency getFrequency(String freq)
    {
        for(Frequency frequency : Frequency.values())
        {
            if(freq.equals(frequency.value))
            {
                return frequency;
            }
        }
        return null;   //handle using User defined Exception
    }
}
