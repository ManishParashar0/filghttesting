package LoginRegister;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

public class Log extends HttpServlet {

	private boolean jdbclogin;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String pswrd = req.getParameter("pswrd");
		PrintWriter out = resp.getWriter();
//		out.print("<h1>hello</h1>");
//		out.print("<h1> our compaony boat are ready to work </h1>");
		jdbclogin = Loginjdbc.jdbclogin(pswrd, name);
		Cookie[] cookies = req.getCookies();
		 String cookiename = null ;
		 String cookievalue = null;
		for (int i = 0; i < cookies.length; i++) {
			cookiename= cookies[i].getName();
			cookievalue= cookies[i].getValue();
		}
		
		
		if (jdbclogin==true&&cookievalue.equals(name)) {
			
    	   System.out.println("true");
    	   //out.print("<h1>succes</h1>");
    		
    	   	 out.print("<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\"><strong>flighto </strong> welcome back "+cookievalue+" <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">   <span aria-hidden=\"true\">&times;</span>  </button></div>"); 
   		RequestDispatcher rd=req.getRequestDispatcher("/flight.html");
   		rd.include(req, resp); 
  // rd.forward(req, resp);
   		
	}else {
		 out.print("<h1>password is worng kindly enter valid pass</h1>");
		 RequestDispatcher requestDispatcher = req.getRequestDispatcher("/NewFile.html");
		System.out.println("work");
			requestDispatcher.include(req, resp);
		
	}
	}
}
