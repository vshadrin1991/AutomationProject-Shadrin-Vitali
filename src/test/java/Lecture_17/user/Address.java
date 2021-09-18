package Lecture_17.user;

import lombok.Data;

import java.util.List;
@Data
public class Address {
    public String city;
    public String street;
    public String building;
    public Object description;
    public double lat;
    public double lng;
    public String raw;
    public Object metro;
    public List<Object> metro_stations;
    public String id;
}
