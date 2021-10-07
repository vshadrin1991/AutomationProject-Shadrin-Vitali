package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySqlReader {

    public Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://db4free.net/testqa07?user=testqa07&password=testqa07");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Statement statement() {
        try {
            return connect().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

