package model;

import dao.BaseModelObject;
import dao.IPersistenceManager;
import model.Type.CompanyState;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company extends BaseModelObject {
    private String code;
    private String name;
    private String state;
    private String organizationalCode;
    private String industryGenera;
    private String industry;
    private String businessCategory;
    private String contact;
    private String contactNumber;
    private Set<Riskcheck> riskchecks;

    public static Company create(IPersistenceManager pm, String code, String name, CompanyState state, String organizationalCode,
                                 String industryGenera, String industry, String businessCategory, String contact, String contactNumber) {
        Company result = new Company();
        result.setCode(code);
        result.setName(name);
        result.setState(state.getName());
        result.setOrganizationalCode(organizationalCode);
        result.setIndustryGenera(industryGenera);
        result.setIndustry(industry);
        result.setBusinessCategory(businessCategory);
        result.setContact(contact);
        result.setContactNumber(contactNumber);

        pm.save(result);
        return result;
    }


    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "state", nullable = false, length = 45)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "organizationalCode", nullable = false, length = 45)
    public String getOrganizationalCode() {
        return organizationalCode;
    }

    public void setOrganizationalCode(String organizationalCode) {
        this.organizationalCode = organizationalCode;
    }

    @Column(name = "industryGenera", nullable = false, length = 45)
    public String getIndustryGenera() {
        return industryGenera;
    }

    public void setIndustryGenera(String industryGenera) {
        this.industryGenera = industryGenera;
    }

    @Column(name = "industry", nullable = false, length = 100)
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Column(name = "businessCategory", nullable = false, length = 100)
    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    @Column(name = "contact", nullable = false, length = 45)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "contactNumber", nullable = false, length = 45)
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Access(AccessType.PROPERTY)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Riskcheck> getRiskchecks() {
        return riskchecks;
    }

    public void setRiskchecks(Set<Riskcheck> riskchecks) {
        this.riskchecks = riskchecks;
    }
}
