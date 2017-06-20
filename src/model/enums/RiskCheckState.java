package model.enums;

public enum RiskCheckState {
    UNDERGOING("进行中"),
    FINISHED("已完成");

    private String value;

    private RiskCheckState(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static RiskCheckState fromString(String value) {
        RiskCheckState riskCheckState = null;
        if ("进行中".equals(value)) {
            riskCheckState = UNDERGOING;
        } else if ("已完成".equals(value)) {
            riskCheckState = FINISHED;
        }

        return riskCheckState;
    }
}
