package mysql;

import java.sql.ResultSet;

public interface MySqlHelper {
    void execute();
    ResultSet resultSet();
}
