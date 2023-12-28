package org.apache.struts.register.model;

public class Todo {
  private String title;
  private String content;
  private String deadline;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDeadline() {
    return deadline;
  }

  public void setDeadline(String deadline) {
    this.deadline = deadline;
  }

  public String toString() {
    return "Title is " + getTitle() + " Content is " + getContent() + " Deadline is " + getDeadline();
  }
}
