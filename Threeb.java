import java.sql.*;
import java.util.*;

public class Threeb {
  public static void main(String[] args) throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "Pavan222");
    Scanner sc = new Scanner(System.in);
    String rollno = sc.next();

    CallableStatement cs = con.prepareCall("{call showDetails(?)}");
    cs.setString(1, rollno);
    ResultSet rs = cs.executeQuery();
    if(rs.next())
    {
      System.out.println(rs.getString(1));
    }
    else
    {
      System.out.println("No user found");
    }
  }
}
