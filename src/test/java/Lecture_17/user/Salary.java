package Lecture_17.user;

import lombok.Data;

@Data
public class Salary {
    public int from;
    public int to;
    public String currency;
    public boolean gross;
}
