package org.apache.struts.register.db;

import org.apache.struts.register.model.*;
import java.sql.*;
import java.util.ArrayList;

public class TodoTable extends TableImpl {
  public void insert(Bean bean) throws Exception {
    try(Connection con = getConnection();
      PreparedStatement st = con.prepareStatement("insert into todo (title, content, deadline) values(?, ?, ?)");) {

      ArrayList<String> data = bean.getData();
      for(int i = 0; i < data.size();  i++) {
        st.setString(i + 1, data.get(i));
      }

      int line = st.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public ArrayList<Bean> select() throws Exception {
    try(Connection con = getConnection();
      PreparedStatement st = con.prepareStatement("select * from todo");) {
      
      ArrayList<Bean> todos = new ArrayList<>();
      ResultSet rs = st.executeQuery();
  
      while(rs.next()) {
        Todo todo = new Todo();
        todo.setId(rs.getInt("todo_id"));
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setDeadline(rs.getString("deadline"));
        todos.add(todo);
      }

      return todos;
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public Bean selectById(int id) throws Exception {
    try(Connection con = getConnection();
      PreparedStatement st = con.prepareStatement("select * from todo where todo_id = ?");) {
      
      Todo todo = new Todo();
      
      st.setInt(1, id);
      ResultSet rs = st.executeQuery();

      while(rs.next()) {
        todo.setId(id);
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setDeadline(rs.getString("deadline"));
      }
      return todo;
    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public void update(Bean bean, int id) throws Exception {
    try(Connection con = getConnection();
      PreparedStatement st = con.prepareStatement("update todo set title = ?, content = ?, deadline = ? where todo_id = ?");) {
    
      ArrayList<String> data = bean.getData();
      for(int i = 0; i < data.size();  i++) {
        st.setString(i + 1, data.get(i));
      }
      st.setInt(4, id);

      int line = st.executeUpdate();

    } catch(Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public void delete(int id) throws Exception {
    try(Connection con = getConnection();
      PreparedStatement st = con.prepareStatement("delete from todo where todo_id = ?");) {

      st.setInt(1, id);
      int line = st.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}
