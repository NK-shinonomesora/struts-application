package org.apache.struts.register.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.register.model.*;
import org.apache.struts.register.db.*;
import org.apache.struts.register.service.Service;
import org.apache.struts.register.validation.StringValidation;
import java.util.ArrayList;
import java.util.function.BiPredicate;

public class TodoAction extends ActionSupport {
  private static final long serialVersionUID = 1L;
  private int id;
  private Todo todoBean;
  private ArrayList<Todo> todos = new ArrayList<>();
  private static final Service service = new Service();

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
    try {
      service.insert(new TodoTable(), todoBean);
      return SUCCESS;
    } catch(Exception e) {
      return ERROR;
    }

  }

  public String select() throws Exception {
    try {
      setTodos(service.select(new TodoTable()));
      return SUCCESS;
    } catch(Exception e) {
      return ERROR;
    }
  }

  public String selectById() throws Exception {
    try {
      Bean todo = service.selectById(new TodoTable(), id);
      setTodoBean((Todo)todo);
      return SUCCESS;
    } catch(Exception e) {
      return ERROR;
    }

  }

  public String update() throws Exception {
    try {
      service.update(new TodoTable(), todoBean, todoBean.getId());
      return SUCCESS;
    } catch(Exception e) {
      return ERROR;
    }
  }

  public String delete() throws Exception {
    try {
      service.delete(new TodoTable(), id);
      return SUCCESS;
    } catch(Exception e) {
      return ERROR;
    }
  }

  public void validate() {
    if(todoBean != null) {
      BiPredicate<String, Integer> bp = StringValidation.shorterThanSize();
      if(bp.test(todoBean.getTitle(), 0)) addFieldError("todoBean.title", "Title is required.");
      if(bp.test(todoBean.getContent(), 0)) addFieldError("todoBean.content", "Content is required.");
      if(bp.test(todoBean.getDeadline(), 0)) addFieldError("todoBean.deadline", "Deadline is required.");
    }
  }
}
