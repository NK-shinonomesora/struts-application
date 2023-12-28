<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Register</title>
    <s:head />
  </head>
  <body>
    <h3>Register for a todo by completing this form.</h3>

    <s:form action="register">
      <s:textfield name="todoBean.title" label="Title" />
      <s:textfield name="todoBean.content" label="Content" />
      <s:textfield name="todoBean.deadline"  label ="Deadline" />
      <s:submit/>
    </s:form>	
  </body>
</html>