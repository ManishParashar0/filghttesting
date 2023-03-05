package LoginRegister;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bulkdata extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] name = req.getParameterValues("name");
		String[] mobile = req.getParameterValues("mobile");
		
		System.out.println(Arrays.toString(name));
		System.out.println(Arrays.toString(mobile));
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DATA", "root", "MANISH80");
			for(int i=0;i<name.length;i++) {
				PreparedStatement pre = con.prepareStatement("insert into DATA values(?,?)");
				pre.setString(1, name[i]);
				pre.setInt(2, Integer.parseInt(mobile[i]));
				pre.executeUpdate();
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
