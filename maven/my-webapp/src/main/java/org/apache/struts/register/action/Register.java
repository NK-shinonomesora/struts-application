package org.apache.struts.register.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.register.model.Todo;

public class Register extends ActionSupport {
  private static final long serialVersionUID = 1L;
  private Todo todoBean;

  public String execute() throws Exception {
    // ここにTodoをDBに登録するなどの処理を実装
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
