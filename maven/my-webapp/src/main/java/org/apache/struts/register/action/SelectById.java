package org.apache.struts.register.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts.register.db.TodoTable;
import org.apache.struts.register.model.*;
import org.apache.struts.register.service.Service;

public class SelectById extends ActionSupport {
  private int id;
  private Todo todoBean;

  public String execute() throws Exception {
    Service service = new Service();
    Bean todo = service.selectById(new TodoTable(), id);
    setTodoBean((Todo)todo);

    return SUCCESS;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Todo getTodoBean() {
    return todoBean;
  }

  public void setTodoBean(Todo todo) {
    todoBean = todo;
  }
}
