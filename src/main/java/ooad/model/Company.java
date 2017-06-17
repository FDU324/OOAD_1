package ooad.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {
    private int id;

    @Id
    @javax.persistence.Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String code;

    @Basic
    @javax.persistence.Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;

    @Basic
    @javax.persistence.Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String state;

    @Basic
    @javax.persistence.Column(name = "state", nullable = false, length = 45)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String organizationalCode;

    @Basic
    @javax.persistence.Column(name = "organizationalCode", nullable = false, length = 100)
    public String getOrganizationalCode() {
        return organizationalCode;
    }

    public void setOrganizationalCode(String organizationalCode) {
        this.organizationalCode = organizationalCode;
    }

    private String industryGenera;

    @Basic
    @javax.persistence.Column(name = "industryGenera", nullable = true, length = 45)
    public String getIndustryGenera() {
        return industryGenera;
    }

    public void setIndustryGenera(String industryGenera) {
        this.industryGenera = industryGenera;
    }

    private String industry;

    @Basic
    @javax.persistence.Column(name = "industry", nullable = true, length = 45)
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    private String businessCategory;

    @Basic
    @javax.persistence.Column(name = "businessCategory", nullable = true, length = 100)
    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    private String contact;

    @Basic
    @javax.persistence.Column(name = "contact", nullable = true, length = 45)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    private String contactNumber;

    @Basic
    @javax.persistence.Column(name = "contactNumber", nullable = true, length = 45)
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (code != null ? !code.equals(company.code) : company.code != null) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (state != null ? !state.equals(company.state) : company.state != null) return false;
        if (organizationalCode != null ? !organizationalCode.equals(company.organizationalCode) : company.organizationalCode != null)
            return false;
        if (industryGenera != null ? !industryGenera.equals(company.industryGenera) : company.industryGenera != null)
            return false;
        if (industry != null ? !industry.equals(company.industry) : company.industry != null) return false;
        if (businessCategory != null ? !businessCategory.equals(company.businessCategory) : company.businessCategory != null)
            return false;
        if (contact != null ? !contact.equals(company.contact) : company.contact != null) return false;
        if (contactNumber != null ? !contactNumber.equals(company.contactNumber) : company.contactNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (organizationalCode != null ? organizationalCode.hashCode() : 0);
        result = 31 * result + (industryGenera != null ? industryGenera.hashCode() : 0);
        result = 31 * result + (industry != null ? industry.hashCode() : 0);
        result = 31 * result + (businessCategory != null ? businessCategory.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
        return result;
    }
}
