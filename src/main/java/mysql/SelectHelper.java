package mysql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectHelper {
    private String select;
    private String from;
    private String where;
    private static SelectHelper selectHelper;

    public static SelectHelper getSelect() {
        if (selectHelper == null) {
            selectHelper = new SelectHelper();
        }
        return selectHelper;
    }

    public static void reset() {
        selectHelper = new SelectHelper();
    }

    public SelectHelper select(String select) {
        this.select = select;
        return this;
    }

    public SelectHelper from(String from) {
        this.from = from;
        return this;
    }

    public SelectHelper where(String where) {
        this.where = where;
        return this;
    }

    public List<List<String>> getListData() {
        List<List<String>> data = new ArrayList<>();
        try {
            ResultSet resultSet = resultSet();
            while (resultSet.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


    public Map<String, List<String>> getMapData() {
        Map<String, List<String>> data = new HashMap<>();
        List<List<String>> listData = getListData();
        try {
            ResultSet resultSet = resultSet();
            List<String> titles = new ArrayList<>();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                titles.add(resultSet.getMetaData().getColumnLabel(i));
            }
            for (int i = 0; i < titles.size(); i++) {
                List<String> column = new ArrayList<>();
                for (int j = 0; j < listData.size(); j++) {
                    column.add(listData.get(j).get(i));
                }
                data.put(titles.get(i), column);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public ResultSet resultSet() {
        try {
            ResultSet resultSet =
                    new MySqlReader().statement()
                            .executeQuery("select " + this.select + " from " + this.from + (this.where == null ? "" : " where " + this.where));
            reset();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
