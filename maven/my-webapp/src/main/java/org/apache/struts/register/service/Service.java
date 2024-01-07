package org.apache.struts.register.service;

import org.apache.struts.register.model.*;
import org.apache.struts.register.db.*;
import java.util.ArrayList;

public class Service {
  public void insert(Table table, Bean bean) throws Exception {
    table.insert(bean);
  }

  public ArrayList<Bean> select(Table table) throws Exception {
    return table.select();
  }

  public Bean selectById(Table table, int id) throws Exception {
    return table.selectById(id);
  }

  public void update(Table table, Bean bean, int id) throws Exception {
    table.update(bean, id);
  }

  public void delete(Table table, int id) throws Exception {
    table.delete(id);
  }
}
