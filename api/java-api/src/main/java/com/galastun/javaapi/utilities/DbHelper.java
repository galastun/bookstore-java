package com.galastun.javaapi.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

public class DbHelper {
  private Connection conn = null;

  public DbHelper() {
  }

  public void connect(String url, String username, String password) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

      conn = DriverManager.getConnection(String.format("jdbc:mysql://%s", url), username, password);
    } catch (SQLException e) {
      System.out.println(e);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public ArrayList<HashMap<String, Object>> query(String query) {
    ResultSet rs = null;
    ArrayList<HashMap<String, Object>> resultList = new ArrayList<>();
    try (Statement stmt = conn.createStatement();) {
      rs = stmt.executeQuery(query);
      ResultSetMetaData meta = rs.getMetaData();
      int columns = meta.getColumnCount();

      while (rs.next()) {
        HashMap<String, Object> result = new HashMap<>();
        for (int i = 1; i <= columns; i++) {
          String key = meta.getColumnLabel(i);
          String value = meta.getColumnTypeName(i);

          switch (value) {
            case "SMALLINT UNSIGNED":
            case "SMALLINT":
              result.put(key, rs.getInt(key));
              break;
            case "VARCHAR":
              result.put(key, rs.getString(key));
              break;
          }
        }

        resultList.add(result);
      }
    } catch (SQLException e) {
      System.out.println(e);
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {

        }
      }

      rs = null;
    }

    return resultList;
  }
}