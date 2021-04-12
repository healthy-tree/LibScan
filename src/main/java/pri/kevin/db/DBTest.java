package pri.kevin.db;

import java.sql.*;

public class DBTest {
  public static void main(String[] args) {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:sqlite::memory:");
      Statement statement = conn.createStatement();
      statement.setQueryTimeout(5);
      statement.executeUpdate("drop table if exists person");
      statement.executeUpdate("create table person (id integer, name string)");
      statement.executeUpdate("insert into person values(1, 'leo')");
      statement.executeUpdate("insert into person values(2, 'yui')");
      ResultSet resultSet = statement.executeQuery("select * from person");
      while (resultSet.next()) {
        String name = resultSet.getString("name");
        System.out.println(name);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }
}
