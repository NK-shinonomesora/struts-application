package org.apache.struts.register.db;

import org.apache.struts.register.model.*;
import java.util.ArrayList;

public interface Table {
  public void insert(Bean bean);
  public ArrayList<Bean> select();
}
