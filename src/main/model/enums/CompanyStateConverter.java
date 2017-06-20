package main.model.enums;

import javax.persistence.AttributeConverter;

public class CompanyStateConverter implements AttributeConverter<CompanyState, String> {
    @Override
    public String convertToDatabaseColumn(CompanyState companyState) {
        return companyState.getValue();
    }

    @Override
    public CompanyState convertToEntityAttribute(String s) {
        return CompanyState.fromString(s);
    }
}
