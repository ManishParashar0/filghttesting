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

public class Register extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String surname = req.getParameter("surname");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String pswrd = req.getParameter("pswrd");
		PrintWriter out = resp.getWriter();
		Cookie cookie=new Cookie("cookie",name);
		resp.addCookie(cookie);
		try {
			Loginjdbc.jdbcRegister12(name , surname , mobile, email,pswrd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 HttpSession session = req.getSession();
	       session.setAttribute("uname", name);
		RequestDispatcher rd=req.getRequestDispatcher("/flight.html");
         rd.forward(req, resp);
		
		
	}

}