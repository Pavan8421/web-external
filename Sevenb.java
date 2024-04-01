import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/unregister")
public class Sevenb extends HttpServlet{
  PrintWriter out = null;
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
    try{
      res.setContentType("text/html");
      out = res.getWriter();
      String email = (String)req.getParameter("email");
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "Pavan222");
      PreparedStatement ps = con.prepareStatement("DELETE FROM lab_students WHERE email = ?");
      ps.setString(1, email);
      int n = ps.executeUpdate();
      if(n > 0)
      {
        out.println("Successfully unregistered" + email);
      }
    }
    catch(Exception e)
    {
      out.println("Exception" + e.getMessage());
    }
  }
}
