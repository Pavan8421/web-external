import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/insert")

public class Sixb extends HttpServlet {
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
    PrintWriter out = null;
    try {
      res.setContentType("text/html");
      out = res.getWriter();
      String uname = (String)req.getParameter("uname");
      String email = (String)req.getParameter("email");
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "Pavan222");
      PreparedStatement ps = con.prepareStatement("INSERT INTO lab_students VALUES(?,?,?)");
      ps.setString(1, uname);
      ps.setString(2, "abc123456");
      ps.setString(3,email);
      int n = ps.executeUpdate();
      if(n > 0)
      {
        out.println("one row inserted");
      }
    }
    catch (Exception e)
    {
      out.println("Error :" + e.getMessage());
    }
  }
}
