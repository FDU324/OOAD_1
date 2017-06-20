package main.model.Type;

/**
 * Created by asus on 2017/6/20.
 */
public enum CompanyState {
    NORMAL("正常"), UNFINISHED("未完成");


    private String name ;

    CompanyState(String name){
        this.name = name ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
