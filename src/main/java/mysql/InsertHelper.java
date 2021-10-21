package mysql;

import java.sql.ResultSet;

public class InsertHelper extends DBConnector implements MySqlHelper{
    private String table;
    private String into;
    private String values;

    public static InsertHelper getInsert() {
        return new InsertHelper();
    }

    public InsertHelper table(String table) {
        this.table = table;
        return this;
    }

    public InsertHelper into(String into) {
        this.into = into;
        return this;
    }

    public InsertHelper values(String values) {
        this.values = values;
        return this;
    }

    @Override
    public void execute() {
        try {
            getStatement().executeUpdate("INSERT INTO " + table + " ( " + into + " )" + " VALUES " + "( " + values + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet resultSet() {
        return null;
    }
}
