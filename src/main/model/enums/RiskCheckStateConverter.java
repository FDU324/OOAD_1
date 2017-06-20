package main.model.enums;

import javax.persistence.AttributeConverter;

public class RiskCheckStateConverter implements AttributeConverter<RiskCheckState, String> {

    @Override
    public String convertToDatabaseColumn(RiskCheckState riskCheckState) {
        return riskCheckState.getValue();
    }

    @Override
    public RiskCheckState convertToEntityAttribute(String s) {
        return RiskCheckState.fromString(s);
    }
}
