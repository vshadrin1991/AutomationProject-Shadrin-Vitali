package Lecture_23;

public class StaticClass {
    static String name;
    static Integer age;
    public static final Integer phone = 123123213;

    public static void getName() {

    }

    public static void getName(String name) {

    }

    public void getAge() {
    }

    private static void getAge(Integer userAge) {
        age = userAge;
    }

    public static class User {

        public void getUser(){
            getAge(12);
        }
    }

    static {
        name = "Test";
    }
}
