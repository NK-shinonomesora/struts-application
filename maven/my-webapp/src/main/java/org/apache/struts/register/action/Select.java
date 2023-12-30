package org.apache.struts.register.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts.register.db.TodoTable;
import org.apache.struts.register.model.*;
import org.apache.struts.register.service.Service;
import java.util.ArrayList;

public class Select extends ActionSupport {
  private static final long serialVersionUID = 1L;
  private ArrayList<Todo> todos = new ArrayList<>();

  public String execute() throws Exception {
    Service service = new Service();
    setTodos(service.select(new TodoTable()));

    return SUCCESS;
  }

  public ArrayList<Todo> getTodos() {
    return todos;
  }

  public void setTodos(ArrayList<Bean> todos) {
    for(Bean b : todos) {
      this.todos.add((Todo)b);
    }
  }
}
