package LoginRegister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class Loginjdbc {

	static void jdbcRegister12(String name, String surname, String mobile, String email, String pswrd)
			throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AI", "root", "MANISH80");
			PreparedStatement pre = con.prepareStatement("insert into AI values(?,?,?,?,?)");
			pre.setString(1, name);
			pre.setString(2, surname);
			pre.setString(3, mobile);
			pre.setString(4, email);
			pre.setString(5, pswrd);
			pre.executeUpdate();
			System.out.println("fill into database succes....");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static boolean jdbclogin(String pswrd, String name) {
		Connection con = null;
		boolean set = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AI", "root", "MANISH80");
			PreparedStatement pre = con.prepareStatement("select * from Ai");
			ResultSet execute = pre.executeQuery();
			while (execute.next()) {
				String username = execute.getString("name");
				String pswd = execute.getString("password");
				System.out.println(username + "\t\t" + "HELO" + "\t\t" + pswd);
				System.out.println("fill into database succes....");
				if (username.equals(name) && pswd.equals(pswrd)) {

					System.out.println("hello");
					set = true;
				} else {
					System.out.println("nahi gya");
					set = false;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return set;

	}

	static boolean FORGOT(String MOBILENUM) {
		Connection con = null;
		boolean set = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AI", "root", "MANISH80");
			PreparedStatement pre = con.prepareStatement("select * from Ai");
			ResultSet execute = pre.executeQuery();
			while (execute.next()) {
				String MOBILE = execute.getString("MOBILE");
				System.out.println("\t\t" + "HELO" + "\t\t" + MOBILE);
				System.out.println("fill into database succes....");
				if (MOBILENUM.equals(MOBILE)) {
					System.out.println(MOBILE);
					System.out.println("IN ONE");
					set = true;
					break;
				} else {
					System.out.println("no numbar");
					set = false;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return set;

	}

	public static void flight(String from, String where, String startdate, String returndate, String totalpassanger) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FLIGHT", "root", "MANISH80");
			PreparedStatement pre = con.prepareStatement("insert into passangerdata values(?,?,?,?,?)");
			pre.setString(1, from);
			pre.setString(2, where);
			pre.setString(3, startdate);
			pre.setString(4, returndate);
			pre.setString(5, totalpassanger);
			pre.executeUpdate();
			System.out.println("fill into database succes....");
		} catch (Exception e) {
			System.out.println(e);

		}
		System.out.println("SUCESS");
	}
}
