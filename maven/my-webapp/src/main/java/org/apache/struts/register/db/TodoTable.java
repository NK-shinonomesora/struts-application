package org.apache.struts.register.db;

import org.apache.struts.register.model.*;
import java.sql.*;
import java.util.ArrayList;

public class TodoTable extends TableImpl {
  public void insert(Bean bean) {
    try {
      Connection con = getConnection();
      PreparedStatement st = con.prepareStatement("insert into todo (title, content, deadline) values(?, ?, ?)");
      
      ArrayList<String> data = bean.getData();
      for(int i = 0; i < data.size();  i++) {
        st.setString(i + 1, data.get(i));
      }

      int line = st.executeUpdate();

      con.commit();
      st.close();
      con.close();
    } catch(Exception e) {

    }
  }

  public ArrayList<Bean> select() {
    try {
      Connection con = getConnection();
      ArrayList<Bean> todos = new ArrayList<>();

      PreparedStatement st = con.prepareStatement("select * from todo");
      ResultSet rs = st.executeQuery();
  
      while(rs.next()) {
        Todo todo = new Todo();
        todo.setId(rs.getInt("todo_id"));
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setDeadline(rs.getString("deadline"));
        todos.add(todo);
      }
      st.close();
      con.close();
      return todos;
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Bean selectById(int id) {
    try {
      Connection con = getConnection();
      Todo todo = new Todo();

      PreparedStatement st = con.prepareStatement("select * from todo where todo_id = ?");
      st.setInt(1, id);
      ResultSet rs = st.executeQuery();

      while(rs.next()) {
        todo.setId(id);
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setDeadline(rs.getString("deadline"));
      }
      st.close();
      con.close();
      return todo;
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
