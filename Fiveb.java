import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/login")

public class Fiveb extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    PrintWriter out = null;
    try {
      res.setContentType("text/html");
      out = res.getWriter();
      String uname = (String)req.getParameter("uname");
      String psswd = (String)req.getParameter("psswd");

      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "Pavan222");
      PreparedStatement ps = con.prepareStatement("SELECT * FROM lab_students WHERE uname=? AND psswd=?");
      ps.setString(1, uname);
      ps.setString(2, psswd);
      ResultSet rs = ps.executeQuery();
      if(!rs.next()) {
        out.println("No valid user is found with the given credentials!! please login again");
      } else {
        out.println("Hi " + uname + " you have Successfully logged in");
      }
    } catch(Exception e) {
      out.println("Exception: " + e);
    }
  }
}
