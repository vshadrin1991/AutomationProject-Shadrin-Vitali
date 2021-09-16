package patterns;

import java.util.Set;

public class PersonBuilder {
    private String name = "name";
    private String surname = "surname";
    private int age= 30;
    private int height= 180;
    private int weight = 70;
    private Set<PersonBuilder> parents;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public Set<PersonBuilder> getParents() {
        return parents;
    }

    public static class Builder {
        private PersonBuilder newPerson;

        public Builder() {
            newPerson = new PersonBuilder();
        }

        public Builder withName(String name) {
            newPerson.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            newPerson.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            newPerson.age = age;
            return this;
        }

        public Builder withHeight(int height) {
            newPerson.height = height;
            return this;
        }

        public Builder withWeight(int weight) {
            newPerson.weight = weight;
            return this;
        }

        public Builder withParents(Set<PersonBuilder> parents) {
            newPerson.parents = parents;
            return this;
        }

        public PersonBuilder build() {
            return newPerson;
        }
    }

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", parents=" + parents +
                '}';
    }
}