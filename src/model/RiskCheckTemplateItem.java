package model;

import dao.BaseModelObject;
import dao.IPersistenceManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "riskchecktemplateitem")
public class RiskCheckTemplateItem extends BaseModelObject {
    private String name;
    private String content;

    public static RiskCheckTemplateItem create(IPersistenceManager pm, String name, String content) {
        RiskCheckTemplateItem re = new RiskCheckTemplateItem();
        re.setName(name);
        re.setContent(content);

        pm.save(re);
        return re;
    }


    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "content", nullable = false, length = 100)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
