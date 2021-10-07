package Lecture_19;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;
import java.util.Map;

import static mysql.SelectHelper.getSelect;

public class Lecture_19 {


    @Test
    public void test() throws Exception {
        Map<String, List<String>> resultMap = getSelect().select("*").from("user").getMapData();
        List<List<String>> resultList = getSelect().select("*").from("user").getListData();
    }


    @Test
    public void test1() throws Exception {
        Connection connect = DriverManager.getConnection("jdbc:mysql://db4free.net/testqa07?user=testqa07&password=testqa07");
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement
                .executeQuery("select * from user");
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String firstname = resultSet.getString(2);
            String lastname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            System.out.println(id + ", " + firstname + ", " + lastname + ", " + age);
        }
        connect.close();
    }
}
