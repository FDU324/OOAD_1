package model.enums;


public enum CompanyState {
    NORMAL("正常"),
    ABSENT("信息待完善");

    private String value;

    private CompanyState(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static CompanyState fromString(String value) {
        CompanyState companyState = null;
        if ("正常".equals(value)) {
            companyState = NORMAL;
        } else if ("信息待完善".equals(value)) {
            companyState = ABSENT;
        }

        return companyState;
    }


}
