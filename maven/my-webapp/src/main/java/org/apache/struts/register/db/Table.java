package org.apache.struts.register.db;

import org.apache.struts.register.model.*;
import java.util.ArrayList;

public interface Table {
  public void insert(Bean bean) throws Exception;
  public ArrayList<Bean> select() throws Exception;
  public Bean selectById(int id) throws Exception;
  public void update(Bean bean, int id) throws Exception;
  public void delete(int id) throws Exception;
}
