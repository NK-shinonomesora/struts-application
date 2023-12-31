package org.apache.struts.register.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.register.model.*;
import org.apache.struts.register.db.*;
import org.apache.struts.register.service.Service;
import java.util.ArrayList;

public class TodoAction extends ActionSupport {
  private static final long serialVersionUID = 1L;
  private int id;
  private Todo todoBean;
  private ArrayList<Todo> todos = new ArrayList<>();

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

  public ArrayList<Todo> getTodos() {
    return todos;
  }

  public void setTodos(ArrayList<Bean> todos) {
    for(Bean b : todos) {
      this.todos.add((Todo)b);
    }
  }

  public String insert() throws Exception {
    Service service = new Service();
    service.insert(new TodoTable(), todoBean);

    return SUCCESS;
  }

  public String select() throws Exception {
    Service service = new Service();
    setTodos(service.select(new TodoTable()));

    return SUCCESS;
  }

  public String selectById() throws Exception {
    Service service = new Service();
    Bean todo = service.selectById(new TodoTable(), id);
    setTodoBean((Todo)todo);

    return SUCCESS;
  }

  public String update() throws Exception {
    Service service = new Service();
    service.update(new TodoTable(), todoBean, todoBean.getId());

    return SUCCESS;
  }

  public void validate() {
    if(todoBean != null) {
      if(todoBean.getTitle().length() == 0) addFieldError("todoBean.title", "Title is required.");
      if(todoBean.getContent().length() == 0) addFieldError("todoBean.content", "Content is required.");
      if(todoBean.getDeadline().length() == 0) addFieldError("todoBean.deadline", "Deadline is required.");
    }
  }
}
