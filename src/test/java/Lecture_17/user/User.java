package Lecture_17.user;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    public String id;
    public boolean premium;
    public String name;
    public Object department;
    public boolean has_test;
    public boolean response_letter_required;
    public Area area;
    public Salary salary;
    public Type type;
    public Address address;
    public Object response_url;
    public Object sort_point_distance;
    public Date published_at;
    public Date created_at;
    public boolean archived;
    public String apply_alternate_url;
    public Object insider_interview;
    public String url;
    public String alternate_url;
    public List<Object> relations;
    public Employer employer;
    public Snippet snippet;
    public Object contacts;
    public Schedule schedule;
    public List<Object> working_days;
    public List<Object> working_time_intervals;
    public List<Object> working_time_modes;
    public boolean accept_temporary;
}
