package Lecture_16;


import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Pet {
    private String type;
    private Integer age;
    private String name;
}
