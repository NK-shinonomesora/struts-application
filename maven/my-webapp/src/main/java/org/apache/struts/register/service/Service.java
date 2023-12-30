package org.apache.struts.register.service;

import org.apache.struts.register.model.*;
import org.apache.struts.register.db.*;

public class Service {
  public void insert(Table table, Bean bean) {
    table.insert(bean);
  } 
}
