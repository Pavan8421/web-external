import java.sql.*;
import java.util.*;
public class Oneb {
  public static void main(String[] args) throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "Pavan222");
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter rollno: ");
    String rollno = sc.next();
    System.out.println("Enter new mobile number : ");
    String mnum = sc.next();
    PreparedStatement ps = con.prepareStatement("UPDATE student SET mnum = ? WHERE rollno = ?");
    ps.setString(1, mnum);
    ps.setString(2, rollno);
    int n = ps.executeUpdate();

    if(n >= 0)
    {
      System.out.println("updated successfully");
    }

  }
}
