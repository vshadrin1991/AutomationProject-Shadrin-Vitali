package pojo;


import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Pet {
    private String type;
    private Integer age;
    private String name;
}
