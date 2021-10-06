package Lecture_19;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Lecture_19 {

    @Test
    public void test1() throws Exception {
        Connection connect = DriverManager.getConnection("jdbc:mysql://db4free.net/testqa07?user=testqa07&password=testqa07");
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement
                .executeQuery("select * from user where first_name='Test'");
        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String firstname = resultSet.getString(2);
            String lastname = resultSet.getString(3);
            Integer age = resultSet.getInt(4);
            System.out.println(id + ", " + firstname + ", " + lastname + ", " + age);
        }
        connect.close();
    }
}
