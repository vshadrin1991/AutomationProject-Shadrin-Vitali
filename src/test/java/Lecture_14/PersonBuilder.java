package Lecture_14;

import properties.PropertyReader;

public class PersonBuilder {
    String name = PropertyReader.getProperties().getProperty("url");
    String lastName= "test";
    Integer age = Integer.parseInt(PropertyReader.getProperties().getProperty(""));
    String sex = "Female";
    Integer phoneNumber = 1111111111;

    public static class Builder {
        private PersonBuilder personBuilder;

        public Builder() {
            personBuilder = new PersonBuilder();
        }

        public Builder withName(String name) {
            personBuilder.name = name;
            return this;
        }

        public Builder withPhone(Integer phoneNumber) {
            personBuilder.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withLastName(String lastName) {
            personBuilder.lastName = lastName;
            return this;
        }

        public Builder withAge(Integer age) {
            personBuilder.age = age;
            return this;
        }

        public Builder withSex(String sex) {
            personBuilder.sex = sex;
            return this;
        }

        public PersonBuilder build() {
            return personBuilder;
        }
    }

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
