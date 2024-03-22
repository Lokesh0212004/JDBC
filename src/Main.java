import java.sql.*;
import java.util.Scanner;
public class Main {
    Scanner in = new Scanner(System.in);
    public static String url = "jdbc:mysql://localhost:3306/Athetication";
    public static String username = "root";
    public static String password = "1234";

    void Insert_pst() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Create a Username");
        String user = in.nextLine();
        System.out.println("Create a password");
        String pass = in.nextLine();
        String query = " insert into login1 (username,password) values (?,?);";
        //creating a connection to database using Driver manager
        Connection con = DriverManager.getConnection(url, username, password);
        //creating preparedStatement to make inserting the values much easier
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, user);
        pst.setString(2, pass);
        //prepared statement returns integer if the query is delivered to the database
        int row = pst.executeUpdate();
        System.out.println("Account Created!!");
    }

    void display() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("============================================");
        System.out.print("Enter the Username\t\t:");
        String user = in.nextLine();
        System.out.print("Enter the Password\t\t:");
        String pass = in.nextLine();
        System.out.println("============================================");
        String query = "select * from login1 where username ='" + user + "'" + " and password='" + pass + "'" + ";";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            System.out.println("welcome!! " + rs.getString(1));

        } else {

            System.err.println("Access Denied!!");
        }
    }
}


    class login{
    static int choice;
    public static void main(String[] args) throws Exception{
        Main m=new Main();

        Scanner in=new Scanner(System.in);
        while (choice!=3) {
            System.out.println("========================");
            System.out.println("1.login");
            System.out.println("2.Create new Account");
            System.out.println("3.Exit");
            System.out.println("========================");
            System.out.println("Enter your choice");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    m.display();
                    break;
                case 2:
                    m.Insert_pst();
                    break;
            }
            }

    }
}