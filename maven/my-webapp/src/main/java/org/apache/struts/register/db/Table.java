package org.apache.struts.register.db;

import org.apache.struts.register.model.*;
import java.util.ArrayList;

public interface Table {
  public void insert(Bean bean);
  public ArrayList<Bean> select();
  public Bean selectById(int id);
  public void update(Bean bean, int id);
  public void delete(int id);
}
