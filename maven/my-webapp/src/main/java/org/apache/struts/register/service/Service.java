package org.apache.struts.register.service;

import org.apache.struts.register.model.*;
import org.apache.struts.register.db.*;
import java.util.ArrayList;

public class Service {
  public void insert(Table table, Bean bean) {
    table.insert(bean);
  }

  public ArrayList<Bean> select(Table table) {
    return table.select();
  }

  public Bean selectById(Table table, int id) {
    return table.selectById(id);
  }

  public void update(Table table, Bean bean, int id) {
    table.update(bean, id);
  }

  public void delete(Table table, int id) {
    table.delete(id);
  }
}
