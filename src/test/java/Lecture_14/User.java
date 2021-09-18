package Lecture_14;

public class User {
    String name;
    Integer age;
    Integer phoneNumber;
    Boolean pets;

    public User() {
    }

    public User(String name, Integer age, Integer phoneNumber, Boolean pets) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getPets() {
        return pets;
    }

    public void setPets(Boolean pets) {
        this.pets = pets;
    }
}
