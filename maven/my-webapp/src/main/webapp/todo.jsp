<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Description a todo</title>
  </head>
  <body>
    <h3>Description a todo.</h3>

    <p><s:property value="todoBean"/></p>

    <p><a href="<s:url action='index'/>" >Return to home page</a>.</p>
  </body>
</html>