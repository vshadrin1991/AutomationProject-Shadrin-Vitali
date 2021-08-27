package composition;

public class Person {
    Integer age;
    String name;
    Integer sex;
    Hand hand;

    public Person() {
        this.hand = new Hand();
        hand.setFingers(5);
    }

    public Integer getFingers() {
        return hand.getFingers();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
