package reflect.entity;

import java.util.Date;

public class Entity01 {
    //成员属性
    private String privateName ;
    Integer defaultAge;
    protected Boolean sex;
    public Date birthday;
    public Date birthday02;
    //构造方法
    private Entity01(){}
    Entity01(Integer defaultAge){this.defaultAge=defaultAge;};
    protected  Entity01(Boolean sex){this.sex=sex;};
    public Entity01(Date birthday){this.birthday=birthday;};

    //成员方法

    public String getPrivateName() {
        return privateName;
    }

    private void setPrivateName(String privateName) {
        this.privateName = privateName;
    }

    public Integer getDefaultAge() {
        return defaultAge;
    }

    void setDefaultAge(Integer defaultAge) {
        this.defaultAge = defaultAge;
    }

    public Boolean getSex() {
        return sex;
    }

    protected void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Entity01{" +
                "privateName='" + privateName + '\'' +
                ", defaultAge=" + defaultAge +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }
}
