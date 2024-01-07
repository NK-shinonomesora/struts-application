<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Description a todo</title>
    <s:head />
  </head>
  <body>
    <h3>Description a todo.</h3>

    <s:form action="update">
      <s:textfield name="todoBean.id" style="display: none;"/>
      <s:textfield name="todoBean.title" label="Title"/>
      <s:textarea name="todoBean.content" label="Content" />
      <s:textfield name="todoBean.deadline" label="Deadline" type="date" format="dd-MM-yyyy" />
      <s:submit value="Update"/>
    </s:form>

    <s:url action="delete" var="deleteLink">
      <s:param name="id"><s:property value="todoBean.id"/></s:param>
    </s:url>
    <button><a href="${deleteLink}">Delete</a></button>

    <p><a href="<s:url action='index'/>" >Return to home page</a>.</p>
  </body>
</html>