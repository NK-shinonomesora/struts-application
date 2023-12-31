package org.apache.struts.register.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.register.model.*;
import org.apache.struts.register.db.*;
import org.apache.struts.register.service.Service;

public class Update extends ActionSupport {
  private static final long serialVersionUID = 1L;
  private Todo todoBean;

  public String execute() throws Exception {
    Service service = new Service();
    service.update(new TodoTable(), todoBean, todoBean.getId());

    return SUCCESS;
  }

  public Todo getTodoBean() {
    return todoBean;
  }

  public void setTodoBean(Todo todo) {
    todoBean = todo;
  }

  public void validate() {
    if(todoBean.getTitle().length() == 0) addFieldError("todoBean.title", "Title is required.");
    if(todoBean.getContent().length() == 0) addFieldError("todoBean.content", "Content is required.");
    if(todoBean.getDeadline().length() == 0) addFieldError("todoBean.deadline", "Deadline is required.");
  }
}
