package org.apache.struts.register.model;

import java.util.ArrayList;

public class Todo implements Bean {
  private int id;
  private String title;
  private String content;
  private String deadline;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public ArrayList<String> getData() {
    ArrayList<String> list = new ArrayList<>();
    list.add(getTitle());
    list.add(getContent());
    list.add(getDeadline());
    return list;
  }
}
