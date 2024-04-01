import java.sql.*;
import java.util.*;

public class Twob {
  public static void main(String args[]) throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "Pavan222");
    System.out.println("Displaying student table");
    PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
    ResultSet rs = ps.executeQuery();
    ResultSetMetaData rms = rs.getMetaData();
    int ncol = rms.getColumnCount();
    while(rs.next())
    {
      for(int i = 0;i < ncol;i++)
      {
        System.out.print(rs.getString(i+1)+"\t");
      }
      System.out.println();
    }
  }
}
