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
}
