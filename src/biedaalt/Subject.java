package biedaalt;

public class Subject {

    // String subject = "CS204/DataStructure/3.0";
    // String values[] = subject.split("/");
    // Хичээл
    public String code;// код
    public String name;// нэр
    public float credit;// нэр

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

}