<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registration Successful</title>
  </head>
  <body>
    <h3>Registered all todos.</h3>

    <table>
      <thead>
        <tr>
          <th colspan="3">Running tasks.</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Title</td>
          <td>Content</td>
          <td>Deadline</td>
        </tr>
        <s:iterator value="todos">
          <s:url action="selectById" var="selectLink">
            <s:param name="id"><s:property value="id"/></s:param>
          </s:url>
          <tr>
            <td>
              <a href="${selectLink}"><s:property value="title"/></a>
            </td>
            <td><s:property value="content"/></td>
            <td><s:property value="deadline"/></td>
          </tr>
        </s:iterator>
      </tbody>
    </table>

    <p><a href="<s:url action='index'/>" >Return to home page</a>.</p>
  </body>
</html>