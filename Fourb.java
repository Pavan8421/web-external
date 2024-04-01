import java.sql.*;
import java.util.*;

class Fourb {
  public static void main(String[] args) throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Pavan222");
    Scanner sc = new Scanner(System.in);

    String rollno = sc.next();
    String name = sc.next();
    String mnum = sc.next();

    PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES(?,?,?);");

    ps.setString(1, rollno);
    ps.setString(2, name);
    ps.setString(3, mnum);
    int n = ps.executeUpdate();

    if (n >= 0) {
      System.out.println("successfully inserted");
    }
  }
}