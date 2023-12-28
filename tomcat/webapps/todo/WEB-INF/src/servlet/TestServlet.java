package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.*;
import database.*;

@WebServlet(urlPatterns={"/servlet/sample"})
public class TestServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/plain; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("insert todo");

    DAO dao = new DAO();
    try {
    Connection con = dao.getConnection();

    PreparedStatement st = con.prepareStatement("insert into todo values(?, ?, ?, ?)");
    st.setInt(1, 2);
    st.setString(2, "meeting");
    st.setString(3, "meeging setting");
    st.setString(4, "20240110");

    int line = st.executeUpdate();

    con.commit();
    st.close();
    con.close();
    } catch(Exception e) {

    }
    
  }
}